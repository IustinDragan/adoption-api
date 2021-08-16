package com.p5.adoptions.service;

import com.p5.adoptions.repository.shelter.AnimalShelterRepository;
import org.springframework.stereotype.Service;

@Service
public class AnimalShelterService
{
    private final AnimalShelterRepository animalShelterRepository;

    public AnimalShelterService(AnimalShelterRepository animalShelterRepository)
    {
        this.animalShelterRepository = animalShelterRepository;
    }
}
//Tema: Dog repository, in shalter facem o relatie one to mani si catre dog. In animal facem cu tipurile de mostenire