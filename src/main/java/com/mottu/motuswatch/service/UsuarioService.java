package com.mottu.motuswatch.service;

import com.mottu.motuswatch.dto.UsuarioDTO;
import com.mottu.motuswatch.exception.NotFoundException;
import com.mottu.motuswatch.model.Usuario;
import com.mottu.motuswatch.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario salvar(UsuarioDTO dto) {
        Usuario usuario = Usuario.builder()
                .nome(dto.nome())
                .telefone(dto.telefone())
                .cpf(dto.cpf())
                .build();
        return repository.save(usuario);
    }

    public Page<Usuario> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

    public void deletar(Long id) {
        Usuario usuario = buscarPorId(id);
        repository.delete(usuario);
    }
}
