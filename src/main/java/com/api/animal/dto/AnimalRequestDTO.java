package com.api.animal.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AnimalRequestDTO (
    @NotBlank(message = "Nome é obrigatório") String nome, 
    @NotBlank(message = "Descrição é obrigatória") String descricao, 
    @NotNull(message = "Data de nascimento é obrigatória") 
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dataNascimento, 
    @NotBlank(message = "Espécie é obrigatória") String especie, 
    @NotBlank(message = "Habitat é obrigatório") String habitat, 
    @NotBlank(message = "País de origem é obrigatório") String paisOrigem
){}
