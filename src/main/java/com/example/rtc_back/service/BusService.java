package com.example.rtc_back.service;

import com.example.rtc_back.entity.Bus;
import com.example.rtc_back.repository.BusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BusService {

    private final BusRepository busRepository;

    public List<Bus> getAll() {
        return busRepository.findAll();
    }

    public Optional<Bus> getById(Long id) {
        return busRepository.findById(id);
    }

    public Bus save(Bus bus) {
        if (bus.getId() == null) {
            bus.setId(getNextAvailableId());
        }
        return busRepository.save(bus);
    }

    public void delete(Long id) {
        busRepository.deleteById(id);
    }

    public Bus update(Long id, Bus bus) {
        return busRepository.findById(id).map(existingBus -> {
            existingBus.setNumeroBus(bus.getNumeroBus());
            existingBus.setPlaca(bus.getPlaca());
            existingBus.setCaracteristicas(bus.getCaracteristicas());
            existingBus.setActivo(bus.isActivo());
            existingBus.setMarca(bus.getMarca());
            return busRepository.save(existingBus);
        }).orElseThrow(() -> new RuntimeException("Bus with ID " + id + " not found"));
    }

    private Long getNextAvailableId() {
        List<Long> ids = busRepository.findAll().stream().map(Bus::getId).sorted().toList();
        for (long i = 1; i <= ids.size(); i++) {
            if (!ids.contains(i)) {
                return i;
            }
        }
        return (long) ids.size() + 1;
    }
}
