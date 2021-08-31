package com.p5.adoptions.controllers;


import com.p5.adoptions.repository.cats.Cat;
import com.p5.adoptions.repository.dogs.Dog;
import com.p5.adoptions.repository.shelter.AnimalShelter;
import com.p5.adoptions.service.AnimalShelterService;
import com.p5.adoptions.service.DTO.CatDTO;
import com.p5.adoptions.service.DTO.ListDTO;
import com.p5.adoptions.service.DTO.ShelterDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
//Controller-ul depinde doar de Service.
//Service-ul este dependent de Repository.
//Servici-ul nu depinde de Web
//Repozitory nu depinde de Serviciu
//DTO = Data Tansport/Transfer Object
//Animal shelter din Repository = ShelterDTO din Service

@RestController
@RequestMapping("/api/v1/shelters")
public class AnimalShelterController {

    AnimalShelterService animalShelterService;

    public AnimalShelterController(AnimalShelterService animalShelterService) {
        this.animalShelterService = animalShelterService;
    }

    @GetMapping() //citire de lista
    public ResponseEntity <ListDTO<ShelterDTO>> getShelters(){
        return ResponseEntity.ok(animalShelterService.findAll());
    }
    @GetMapping("/{id}")  //citire de id
    public ResponseEntity <ShelterDTO> getShelter(@PathVariable("id") Integer id){
        return ResponseEntity.ok(animalShelterService.findById(id));
    }

    @PostMapping() //creare
    public ResponseEntity<ShelterDTO> createShelter(@Valid @RequestBody ShelterDTO animalShelter){
        return ResponseEntity.ok(animalShelterService.createShelter(animalShelter));
    }

    @PutMapping("/{id}") //modificare
    public ResponseEntity<ShelterDTO> updateShelter(@PathVariable("id") Integer id,
                                                     @Valid @RequestBody ShelterDTO animalShelter){
        return ResponseEntity.ok(animalShelterService.updateShelter(id, animalShelter));
    }
    @DeleteMapping("/{id}") //stergere
    public ResponseEntity<Object> deleteShelter(@PathVariable("id") Integer id){
        animalShelterService.deleteShelter(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }

    //Crearea unei metode care aduce doar Lista de Cat sau lista de Dog:
    @GetMapping("/{shelterId}/cats")  // pentru ca le aduc in functie de id-ul shalter-ului
    public ResponseEntity<List<CatDTO>> getCatsForShelter (@PathVariable("shelterId") Integer shelterId){
        return ResponseEntity.ok(animalShelterService.findAllCatsByShelter(shelterId));
    }

    @PutMapping("/{shelterId}/cats")
    public ResponseEntity<List<CatDTO>> addNewCatToShelter(@PathVariable("shelterId") Integer shelterId, @RequestBody CatDTO cat){
        return ResponseEntity.ok(animalShelterService.addNewCatToShelter(shelterId, cat));
    }
    //adaugat de pe gitHub

    @PatchMapping("/{shelterId}/cats/{catId}")
    public ResponseEntity<Cat> updateCatInShelter(@PathVariable("shelterId") Integer shelterId, @PathVariable("catId") Integer catId,
                                                  @RequestBody Cat cat){
        return ResponseEntity.ok(animalShelterService.updateCatInShelter(shelterId, catId, cat));
    }
    @DeleteMapping("/{shelterId}/cats/{catId}")
    public ResponseEntity<Object> deleteCatInShelter(@PathVariable("shelterId") Integer shelterId, @PathVariable("catID") Integer catId){
        animalShelterService.deleteCatInShelter(shelterId, catId);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }
    @GetMapping("/{shelterId}/dogs")
    public ResponseEntity<List<Dog>> getDogsForShelter(@PathVariable("shelterId") Integer shelterId){
        return ResponseEntity.ok(animalShelterService.findAllDogsByShelter(shelterId));
    }
    @PutMapping("/{shelterId}/dogs")
    public ResponseEntity<List<Dog>> addNewDogToShelter(@PathVariable("shelterId") Integer shelterId, @RequestBody Dog dog){
        return ResponseEntity.ok(animalShelterService.addNewDogToShelter(shelterId, dog));
    }
    @PutMapping("/{shelterId}/dogs/{dogId}")
    public ResponseEntity<Dog> undateDogInShelter(@PathVariable("shelterId") Integer shelterId, @PathVariable("dogId") Integer dogId,
                                                  @RequestBody Dog dog){
        return ResponseEntity.ok(animalShelterService.updateDogInShelter(shelterId,dogId,dog));
    }
    @DeleteMapping("/{shelterId}/dogs/{dogId}")
    public ResponseEntity<Object> deleteDogInShelter(@PathVariable("shelterId") Integer shelterId, @PathVariable("dogId") Integer dogId){
        animalShelterService.deleteDogInShelter(shelterId, dogId);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }



}
