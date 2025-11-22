package com.api.animal.dto;

import java.util.Date;

public record AnimalResponseDTO (
    Long id, String nome, String descricao, Date dataNascimento, String especie, String habitat, String paisOrigem){}
