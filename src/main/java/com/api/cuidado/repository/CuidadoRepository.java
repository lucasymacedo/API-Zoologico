package com.api.cuidado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.cuidado.model.Cuidado;

public interface CuidadoRepository extends JpaRepository<Cuidado, Long> {
    
}
