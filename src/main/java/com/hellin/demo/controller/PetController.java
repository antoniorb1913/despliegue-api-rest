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

/**
 * @CrossOrigin --> Es una anotación (etiqueta) que da permiso a páginas web externas.
 * En este caso deja que "http://localhost:3000" pueda llamar a este método.
 * @PutMapping --> Otra anotación que indica que este método responde a peticiones HTTP tipo PUT.
 * "/adopt/{id}" --> significa que la URL va a traer un número como id (ejemplo: /adopt/3).
 */
@CrossOrigin(origins = "http://localhost:3000")
@PutMapping("/adopt/{id}")

// Método que recibe un id de mascota desde la URL y devuelve una respuesta HTTP
// @PathVariable --> Le dice a Spring que el "id" que viene en la URL se guarde en esta variable
public ResponseEntity<Pet> adoptPet(@PathVariable Long id) {

    // Busca la mascota en la base de datos por id. Devuelve un Optional (puede estar vacía o no).
    return petRepository.findById(id)

        // .map --> Si la mascota existe, entra aquí
        .map(pet -> {
            // Cambia el estado de adoptado a true (adoptada)
            pet.setAdopt(true);

            // Guarda los cambios en la base de datos y devuelve la mascota actualizada con un 200 OK
            return new ResponseEntity<>(petRepository.save(pet), HttpStatus.OK);
        })

        // .orElseGet --> Si la mascota NO existe, devuelve un error 404 NOT FOUND
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
}

}


