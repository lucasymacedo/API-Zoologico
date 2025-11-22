package com.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.api.animal.dto.AnimalRequestDTO;
import com.api.animal.dto.AnimalResponseDTO;
import com.api.animal.model.Animal;
import com.api.animal.repository.AnimalRepository;
import com.api.cuidado.dto.CuidadoResponseDTO;
import com.api.cuidado.dto.CuidadoRequestDTO;
import com.api.cuidado.model.Cuidado;
import com.api.cuidado.repository.CuidadoRepository;

import jakarta.validation.Valid;


@Controller
public class WebController {
    private final AnimalRepository animalRepository;
    private final CuidadoRepository cuidadoRepository;

    public WebController(AnimalRepository animalRepository, CuidadoRepository cuidadoRepository) {
        this.animalRepository = animalRepository;
        this.cuidadoRepository = cuidadoRepository;
    }

    @GetMapping("/")
    public String index() {

        return "index";
    }

    // ========== ANIMAIS ==========

    @GetMapping("/animais")
    public String listAnimais(Model model) {
        List<AnimalResponseDTO> animais = animalRepository.findAll().stream()
            .map(a -> new AnimalResponseDTO(
                a.getId(),
                a.getNome(),
                a.getDescricao(),
                a.getDataNascimento(),
                a.getEspecie(),
                a.getHabitat(),
                a.getPaisOrigem()))
            .collect(Collectors.toList());
        model.addAttribute("animais", animais);
        return "animais";
    }
    
    @GetMapping("/animais/{id}")
    public String getAnimal(@PathVariable long id, Model model) {
        Animal animal = animalRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
        
        AnimalResponseDTO dto = new AnimalResponseDTO(
            animal.getId(),
            animal.getNome(),
            animal.getDescricao(),
            animal.getDataNascimento(),
            animal.getEspecie(),
            animal.getHabitat(),
            animal.getPaisOrigem());
        
        model.addAttribute("animal", dto);
        return "animal-detalhes";
    }

    @GetMapping("/animais/novo")
    public String showCreateAnimalForm(Model model) {
        model.addAttribute("animal", new AnimalRequestDTO(null, null, null, null, null, null));
        return "animal-form";
    }

    @GetMapping("/animais/{id}/editar")
    public String showEditAnimalForm(@PathVariable long id, Model model) {
        Animal animal = animalRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
        
        AnimalRequestDTO dto = new AnimalRequestDTO(
            animal.getNome(),
            animal.getDescricao(),
            animal.getDataNascimento(),
            animal.getEspecie(),
            animal.getHabitat(),
            animal.getPaisOrigem());
        
        model.addAttribute("animal", dto);
        model.addAttribute("id", id);
        return "animal-form";
    }

    @PostMapping("/animais")
    public String createAnimal(@Valid @ModelAttribute AnimalRequestDTO request,
                        BindingResult bindingResult, 
                        Model model,
                        RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("animal", request);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "animal-form";
        }

        Animal animal = new Animal(
            request.nome(),
            request.descricao(),
            request.dataNascimento(),
            request.especie(),
            request.habitat(),
            request.paisOrigem());
        
        Animal saved = animalRepository.save(animal);
        redirectAttributes.addFlashAttribute("success", "Animal criado com sucesso!");
        return "redirect:/animais/" + saved.getId();
    }
        
    @PostMapping("/animais/{id}")
    public String updateAnimal(@PathVariable long id, 
                               @Valid @ModelAttribute AnimalRequestDTO request,
                               BindingResult bindingResult,
                               Model model,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("animal", request);
            model.addAttribute("id", id);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "animal-form";
        }
        Animal animal = animalRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
        
        animal.setNome(request.nome());
        animal.setDescricao(request.descricao());
        animal.setDataNascimento(request.dataNascimento());
        animal.setEspecie(request.especie());
        animal.setHabitat(request.habitat());
        animal.setPaisOrigem(request.paisOrigem());
        
        animalRepository.save(animal);
        redirectAttributes.addFlashAttribute("success", "Animal atualizado com sucesso!");
        return "redirect:/animais/" + id;
    }

    @PostMapping("/animais/{id}/deletar")
    public String deleteAnimal(@PathVariable long id, RedirectAttributes redirectAttributes) {
        if (!animalRepository.existsById(id)) {
            throw new RuntimeException("Animal não encontrado");
        }
        animalRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Animal deletado com sucesso!");
        return "redirect:/animais";
    }



    // ========== CUIDADOS ==========  
    
    @GetMapping("/cuidados")
    public String listCuidados(Model model) {
        List<CuidadoResponseDTO> cuidados = cuidadoRepository.findAll().stream()
            .map(c -> new CuidadoResponseDTO(
                c.getId(),
                c.getNome(),
                c.getDescricao(),
                c.getFrequencia()))
            .collect(Collectors.toList());
        model.addAttribute("cuidados", cuidados);
        return "cuidados";
    }
    
    @GetMapping("/cuidados/{id}")
    public String getCuidado(@PathVariable long id, Model model) {
        Cuidado cuidado = cuidadoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cuidado não encontrado"));
        
        CuidadoResponseDTO dto = new CuidadoResponseDTO(
            cuidado.getId(),
            cuidado.getNome(),
            cuidado.getDescricao(),
            cuidado.getFrequencia());
        
        model.addAttribute("cuidado", dto);
        return "cuidado-detalhes";
    }

    @GetMapping("/cuidados/novo")
    public String showCreateCuidadoForm(Model model) {
        model.addAttribute("cuidado", new CuidadoRequestDTO(null, null, null));
        return "cuidado-form";
    }

    @GetMapping("/cuidados/{id}/editar")
    public String showEditCuidadoForm(@PathVariable long id, Model model) {
        Cuidado cuidado = cuidadoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cuidado não encontrado"));
        
        CuidadoRequestDTO dto = new CuidadoRequestDTO(
            cuidado.getNome(),
            cuidado.getDescricao(),
            cuidado.getFrequencia());
        
        model.addAttribute("cuidado", dto);
        model.addAttribute("id", id);
        return "cuidado-form";
    }

    @PostMapping("/cuidados")
    public String createCuidado(@Valid @ModelAttribute CuidadoRequestDTO request,
                                BindingResult bindingResult,
                                Model model, 
                                RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
        model.addAttribute("cuidado", request);
        model.addAttribute("errors", bindingResult.getAllErrors());
        return "animal-form";
        } 

        Cuidado cuidado = new Cuidado(
            request.nome(),
            request.descricao(),
            request.frequencia());
        
        Cuidado saved = cuidadoRepository.save(cuidado);
        redirectAttributes.addFlashAttribute("success", "Cuidado criado com sucesso!");
        return "redirect:/cuidados/" + saved.getId();
    }

    @PostMapping("/cuidados/{id}")
    public String updateCuidado(@PathVariable long id, 
                                @Valid @ModelAttribute CuidadoRequestDTO request,
                                BindingResult bindingResult,
                                Model model, 
                                RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("cuidado", request);
            model.addAttribute("id", id);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "cuidado-form";
        }
        Cuidado cuidado = cuidadoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cuidado não encontrado"));
        
        cuidado.setNome(request.nome());
        cuidado.setDescricao(request.descricao());
        cuidado.setFrequencia(request.frequencia());
        
        cuidadoRepository.save(cuidado);
        redirectAttributes.addFlashAttribute("success", "Cuidado atualizado com sucesso!");
        return "redirect:/cuidados/" + id;
    }

    @PostMapping("/cuidados/{id}/deletar")
    public String deleteCuidado(@PathVariable long id, RedirectAttributes redirectAttributes) {
        if (!cuidadoRepository.existsById(id)) {
            throw new RuntimeException("Cuidado não encontrado");
        }
        cuidadoRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Cuidado deletado com sucesso!");
        return "redirect:/cuidados";
    }

}
