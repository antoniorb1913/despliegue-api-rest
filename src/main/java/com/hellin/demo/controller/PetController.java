package com.hellin.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.hellin.demo.entity.Pet;
import com.hellin.demo.repository.PetRepository;


@RestController
@RequestMapping("/pet")
public class PetController {


    private PetRepository petRepository;

    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }   

    @GetMapping ("/list")
    public List<Pet> hello() {
        return petRepository.findAll();
        
    }
}
