package com.p5.adoptions.service.DTO;

import com.p5.adoptions.service.validations.OnCreate;
import com.p5.adoptions.service.validations.OnUpdate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShelterDTO {

    @Null(message = "Id must be null for creation", groups = OnCreate.class)
    @NotNull(message = "Id must have value for update", groups = OnUpdate.class)
    @Min(value = 1, groups = OnUpdate.class)
    private Integer id;

    @NotNull
    @NotBlank
    private String name;

    private String location;
    private List<CatDTO> cats = new ArrayList<>();
    private List<DogDTO> dogs = new ArrayList<>();

    public ShelterDTO() {

    }

    public ShelterDTO(Integer id, String name, String location, List<CatDTO> cats, List<DogDTO> dogs) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.cats = cats;
        this.dogs = dogs;
    }

    public Integer getId() {
        return id;
    }

    public ShelterDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShelterDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public ShelterDTO setLocation(String location) {
        this.location = location;
        return this;
    }

    public List<CatDTO> getCats() {
        return cats;
    }

    public ShelterDTO setCats(List<CatDTO> cats) {
        this.cats = cats;
        return this;
    }

    public List<DogDTO> getDogs() {
        return dogs;
    }

    public ShelterDTO setDogs(List<DogDTO> dogs) {
        this.dogs = dogs;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShelterDTO that = (ShelterDTO) o;
        return id.equals(that.id) && name.equals(that.name) && location.equals(that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location);
    }
}

//Tema: Adapter: dog adapter de creat: ToDTO, From DTO, FromList, To list
//In controller: Inlocuim toate entitatile de tip repository cu entitati de tip DTO, inclusiv parametrii primiti
//La fel si in serviciu: peste tot pe unde returneaza entitati catre controller, trebuie sa returneze DTO-uri si sa primeasca DTO-uri. In metode facem transformarile: din DTO in entitate, din entitate in DTO.
