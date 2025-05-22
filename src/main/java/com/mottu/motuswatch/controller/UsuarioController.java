package com.mottu.motuswatch.controller;

import com.mottu.motuswatch.dto.UsuarioDTO;
import com.mottu.motuswatch.model.Usuario;
import com.mottu.motuswatch.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public Usuario criar(@RequestBody @Valid UsuarioDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public Page<Usuario> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return service.listar(pageable);
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
