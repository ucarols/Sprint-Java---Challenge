package com.mottu.motuswatch.dto;

import com.mottu.motuswatch.model.AreaPatio;
import jakarta.validation.constraints.NotBlank;

public record MotoDTO(
        @NotBlank String placa,
        @NotBlank String modelo,
        AreaPatio area,
        String observacao,
        Long usuarioId
) {}
