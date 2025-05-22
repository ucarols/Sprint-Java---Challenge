package com.mottu.motuswatch.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
        @NotBlank String nome,
        @NotBlank String telefone,
        @NotBlank String cpf
) {}
