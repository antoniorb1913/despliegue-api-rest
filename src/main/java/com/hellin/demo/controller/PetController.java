package com.hellin.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.hellin.demo.entity.Pet;
import com.hellin.demo.repository.PetRepository;


@RestController
@RequestMapping("/pet")
/**
 * En este controlador se espone los enpoint referentes a Pets 
 * @version 1.0
 * @author Antonio Rodriguez
 */
public class PetController {


    private PetRepository petRepository;

    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }  

    /**
     * Este method devuelve el listado de mascotas
     * @return List<Pet> informacion de cada mascota
     */

    @GetMapping ("/list")
    public List<Pet> hello() {
        return petRepository.findAll();
        
    }


@CrossOrigin(origins = "http://localhost:3000")
@PutMapping("/adopt/{id}")
public ResponseEntity<Pet> adoptPet(@PathVariable Long id) {

    return petRepository.findById(id)
        .map(pet -> {
            pet.setAdopt(true);
            return new ResponseEntity<>(petRepository.save(pet), HttpStatus.OK);
        })
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
}
}


