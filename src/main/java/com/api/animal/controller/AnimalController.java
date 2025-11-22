package com.api.animal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.api.animal.dto.AnimalRequestDTO;
import com.api.animal.dto.AnimalResponseDTO;
import com.api.animal.model.Animal;
import com.api.animal.repository.AnimalRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/animais")
public class AnimalController {
    private final AnimalRepository repository;

    AnimalController(AnimalRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public AnimalResponseDTO getById(@PathVariable long id) {
        Animal a = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Id not found"));

        return new AnimalResponseDTO(
            a.getId(),
            a.getNome(),
            a.getDescricao(),
            a.getDataNascimento(),
            a.getEspecie(),
            a.getHabitat(),
            a.getPaisOrigem());
    }

    @PostMapping
    public AnimalResponseDTO create(@RequestBody AnimalRequestDTO request) {
        Animal a = new Animal(request.nome(), request.descricao(), request.dataNascimento(), request.especie(), request.habitat(), request.paisOrigem());
        a = repository.save(a);
        return new AnimalResponseDTO(a.getId(), a.getNome(), a.getDescricao(), a.getDataNascimento(), a.getEspecie(), a.getHabitat(), a.getPaisOrigem());
    }

    @PutMapping("/{id}")
    public AnimalResponseDTO update(@PathVariable long id, @Valid @RequestBody AnimalRequestDTO request) {
        Animal a = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Id not found"));
        a.setNome(request.nome());
        a.setDescricao(request.descricao());
        a.setDataNascimento(request.dataNascimento());
        a.setEspecie(request.especie());
        a.setHabitat(request.habitat());
        a.setPaisOrigem(request.paisOrigem());
        
        Animal updated = repository.save(a);
        
        return new AnimalResponseDTO(
            updated.getId(),
            updated.getNome(), 
            updated.getDescricao(), 
            updated.getDataNascimento(), 
            updated.getEspecie(), 
            updated.getHabitat(), 
            updated.getPaisOrigem()
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Id not found");
        }
        repository.deleteById(id);
    }
    
}
