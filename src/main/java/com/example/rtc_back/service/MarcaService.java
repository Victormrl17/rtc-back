package com.example.rtc_back.service;

import com.example.rtc_back.entity.Marca;
import com.example.rtc_back.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarcaService {

    private final MarcaRepository marcaRepository;

    public List<Marca> getAll() {
        return marcaRepository.findAll();
    }

    public Optional<Marca> getById(Long id) {
        return marcaRepository.findById(id);
    }

    public Marca save(Marca marca) {
        if (marca.getId() == null) {
            marca.setId(getNextAvailableId());
        }
        return marcaRepository.save(marca);
    }

    public void delete(Long id) {
        marcaRepository.deleteById(id);
    }

    private Long getNextAvailableId() {
        List<Long> ids = marcaRepository.findAll().stream().map(Marca::getId).sorted().toList();
        for (long i = 1; i <= ids.size(); i++) {
            if (!ids.contains(i)) {
                return i;
            }
        }
        return (long) ids.size() + 1;
    }
}
