package com.api.cuidado.dto;

import jakarta.validation.constraints.NotBlank;

public record CuidadoRequestDTO (
        @NotBlank(message = "Nome é obrigatório") String nome, 
        @NotBlank(message = "Descrição é obrigatória") String descricao, 
        @NotBlank(message = "Frequência é obrigatória") String frequencia
    ) {}
