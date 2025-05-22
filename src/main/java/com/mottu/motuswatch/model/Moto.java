package com.mottu.motuswatch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String placa;

    @NotBlank
    private String modelo;

    @Enumerated(EnumType.STRING)
    private AreaPatio area;

    private String observacao;

    private LocalDateTime dataEntrada;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
