package com.api.cuidado.controller;

//import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.cuidado.dto.CuidadoRequestDTO;
import com.api.cuidado.dto.CuidadoResponseDTO;
import com.api.cuidado.model.Cuidado;
import com.api.cuidado.repository.CuidadoRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/cuidados")
public class CuidadoController {
    private final CuidadoRepository repository;

    CuidadoController(CuidadoRepository repository) {
        this.repository = repository;
    } 

    @GetMapping("/{id}")
    public CuidadoResponseDTO getById(@PathVariable long id) {
        Cuidado c = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Id not found"));

        return new CuidadoResponseDTO(
            c.getId(),
            c.getNome(),
            c.getDescricao(),
            c.getFrequencia());
        

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CuidadoResponseDTO create(@Valid @RequestBody CuidadoRequestDTO request) {
        Cuidado cuidado = new Cuidado(
            request.nome(),
            request.descricao(),
            request.frequencia());
        
        Cuidado saved = repository.save(cuidado);

        return new CuidadoResponseDTO(
            saved.getId(),
            saved.getNome(),
            saved.getDescricao(),
            saved.getFrequencia());
    }

    @PutMapping("/{id}")
    public CuidadoResponseDTO update(@PathVariable long id, @Valid @RequestBody CuidadoRequestDTO request) {
        Cuidado c = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Id not found"));
        c.setNome(request.nome());
        c.setDescricao(request.descricao());
        c.setFrequencia(request.frequencia());
        
        Cuidado updated = repository.save(c);
        
        return new CuidadoResponseDTO(
            updated.getId(),
            updated.getNome(),
            updated.getDescricao(),
            updated.getFrequencia());
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
