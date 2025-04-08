package com.example.rtc_back.controller;

import com.example.rtc_back.entity.Marca;
import com.example.rtc_back.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marca")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MarcaController {

    private final MarcaRepository marcaRepository;

    @PostMapping
    public Marca crearMarca(@RequestBody Marca marca) {
        return marcaRepository.save(marca);
    }

    @GetMapping
    public List<Marca> getAllMarcas() {
        return marcaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Marca getMarcaById(@PathVariable Long id) {
        return marcaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca no encontrada con id: " + id));
    }
    @PutMapping("/{id}")
    public Marca actualizarMarca(@PathVariable Long id, @RequestBody Marca marca) {
        return marcaRepository.findById(id).map(existingMarca -> {
            existingMarca.setNombre(marca.getNombre());
            return marcaRepository.save(existingMarca);
        }).orElseThrow(() -> new RuntimeException("Marca no encontrada con id: " + id));
    }

    @DeleteMapping("/{id}")
    public void eliminarMarca(@PathVariable Long id) {
        if (!marcaRepository.existsById(id)) {
            throw new RuntimeException("Marca no encontrada con id: " + id);
        }
        marcaRepository.deleteById(id);
    }
}
