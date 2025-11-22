package com.api.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.animal.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{

    
}
