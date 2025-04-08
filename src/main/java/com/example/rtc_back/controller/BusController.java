package com.example.rtc_back.controller;

import com.example.rtc_back.entity.Bus;
import com.example.rtc_back.service.BusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BusController {

    private final BusService busService;

    @GetMapping
    public List<Bus> getAll() {
        return busService.getAll();
    }

    @GetMapping("/{id}")
    public Bus getById(@PathVariable Long id) {
        return busService.getById(id).orElse(null);
    }

    @PostMapping
public Bus crearBus(@RequestBody Bus bus) {
    return busService.save(bus);
}

@PutMapping("/{id}")
public Bus updateBus(@PathVariable Long id, @RequestBody Bus bus) {
    return busService.update(id, bus);
}

@DeleteMapping("/{id}")
public void deleteBus(@PathVariable Long id) {
    busService.delete(id);
}
}
