package com.p5.adoptions.service.adapters;

import com.p5.adoptions.repository.shelter.AnimalShelter;
import com.p5.adoptions.service.DTO.ShelterDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ShelterAdapter {
    public static ShelterDTO toDTO(AnimalShelter shelter){
        return new ShelterDTO()
                .setId(shelter.getId())
                .setName(shelter.getName())
                .setLocation(shelter.getLocation())
                .setCats(CatAdapter.toDTOList(shelter.getCats()))
                .setDogs(DogAdapter.toDTOList(shelter.getDogs()));

        //Cat, Dog, Shelter - de facut adaptere
    }

    public static AnimalShelter fromDTO(ShelterDTO shelterDTO){
        AnimalShelter shelter = new AnimalShelter();

        shelter.setId(shelterDTO.getId());
        shelter.setName(shelterDTO.getName());
        shelter.setLocation(shelterDTO.getLocation());
        shelter.setCats(CatAdapter.fromDTOList(shelterDTO.getCats()));
        shelter.setDogs(DogAdapter.fromDTOList(shelterDTO.getDogs()));


        return shelter;

    }

    public static List<ShelterDTO> toDTOList(List<AnimalShelter> animalShelters){
        return animalShelters
                .stream()
                .map(ShelterAdapter::toDTO)
                .collect(Collectors.toList());
    }
    public static List<AnimalShelter> fromDTOList(List<ShelterDTO> shelterDTOList){
        return shelterDTOList
                .stream()
                .map(ShelterAdapter::fromDTO)
                .collect(Collectors.toList());
    }

}
