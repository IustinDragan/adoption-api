package com.p5.adoptions.controllers;


import com.p5.adoptions.repository.cats.Cat;
import com.p5.adoptions.repository.shelter.AnimalShelter;
import com.p5.adoptions.service.AnimalShelterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shelters")
public class AnimalShelterController {

    AnimalShelterService animalShelterService;

    public AnimalShelterController(AnimalShelterService animalShelterService) {
        this.animalShelterService = animalShelterService;
    }

    @GetMapping() //citire de lista
    public ResponseEntity <List<AnimalShelter>> getShelters(){
        return ResponseEntity.ok(animalShelterService.findAll());
    }
    @GetMapping("/{id}")  //citire de id
    public ResponseEntity <AnimalShelter> getShelter(@PathVariable("id") Integer id){
        return ResponseEntity.ok(animalShelterService.findById(id));
    }

    @PostMapping() //creare
    public ResponseEntity<AnimalShelter> createShelter(@RequestBody AnimalShelter animalShelter){
        return ResponseEntity.ok(animalShelterService.createShelter(animalShelter));
    }

    @PutMapping("/{id}") //modificare
    public ResponseEntity<AnimalShelter> updateShelter(@PathVariable("id") Integer id, @RequestBody AnimalShelter animalShelter){
        return ResponseEntity.ok(animalShelterService.updateShelter(id, animalShelter));
    }
    @DeleteMapping("/{id}") //stergere
    public ResponseEntity<Object> deleteShelter(@PathVariable("id") Integer id){
        animalShelterService.deleteShelter(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }

    //Crearea unei metode care aduce doar Lista de Cat sau lista de Dog:
    @GetMapping("/{shelterId}/cats")  // pentru ca le aduc in functie de id-ul shalter-ului
    public ResponseEntity<List<Cat>> getCatsForShelter (@PathVariable("shelterId") Integer shelterId){
        return ResponseEntity.ok(animalShelterService.findAllCatsByShelter(shelterId));
    }

    @PutMapping("/{shelterId}/cats")
    public ResponseEntity<List<Cat>> addNewCatToShelter(@PathVariable("shelterId") Integer shelterId, @RequestBody Cat cat){
        return ResponseEntity.ok(animalShelterService.addNewCatToShelter(shelterId, cat));
    }
}
