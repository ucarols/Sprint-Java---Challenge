package com.mottu.motuswatch.controller;

import com.mottu.motuswatch.dto.MotoDTO;
import com.mottu.motuswatch.model.Moto;
import com.mottu.motuswatch.service.MotoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/motos")
@RequiredArgsConstructor
public class MotoController {

    private final MotoService service;

    @PostMapping
    public Moto criar(@RequestBody @Valid MotoDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public Page<Moto> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return service.listar(pageable);
    }

    @GetMapping("/area")
    public Page<Moto> porArea(
            @RequestParam String area,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return service.buscarPorArea(area, pageable);
    }

    @GetMapping("/{id}")
    public Moto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
    @GetMapping("/placa/{placa}")
    public Page<Moto> porPlaca(
            @PathVariable String placa,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return service.buscarPorPlaca(placa, pageable);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

}
