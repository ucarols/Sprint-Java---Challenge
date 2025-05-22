package com.mottu.motuswatch.service;

import com.mottu.motuswatch.dto.MotoDTO;
import com.mottu.motuswatch.exception.NotFoundException;
import com.mottu.motuswatch.model.Moto;
import com.mottu.motuswatch.model.Usuario;
import com.mottu.motuswatch.repository.MotoRepository;
import com.mottu.motuswatch.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MotoService {

    private final MotoRepository repository;
    private final UsuarioRepository usuarioRepository;

    public Moto salvar(MotoDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        Moto moto = Moto.builder()
                .placa(dto.placa())
                .modelo(dto.modelo())
                .area(dto.area())
                .observacao(dto.observacao())
                .dataEntrada(LocalDateTime.now())
                .usuario(usuario)
                .build();

        return repository.save(moto);
    }

    public Page<Moto> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Cacheable("motosPorArea")
    public Page<Moto> buscarPorArea(String area, Pageable pageable) {
        try {
            var areaEnum = com.mottu.motuswatch.model.AreaPatio.valueOf(area.toUpperCase());
            return repository.findByArea(areaEnum, pageable);
        } catch (IllegalArgumentException e) {
            throw new NotFoundException("Área inválida: " + area);
        }
    }

    public Page<Moto> buscarPorPlaca(String placa, Pageable pageable) {
        return repository.findByPlacaContainingIgnoreCase(placa, pageable);
    }

    public Moto buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Moto não encontrada"));
    }

    public void deletar(Long id) {
        Moto moto = buscarPorId(id);
        repository.delete(moto);
    }
}
