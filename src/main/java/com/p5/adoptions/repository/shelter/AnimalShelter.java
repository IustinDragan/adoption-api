package com.p5.adoptions.repository.shelter;


import com.p5.adoptions.repository.cats.Cat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AnimalShelter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String name;

    @OneToMany
    @JoinColumn(name="shelter_id")
    private List<Cat> cats = new ArrayList<>();




    public Integer getId() {
        return id;
    }

    public AnimalShelter setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AnimalShelter setName(String name) {
        this.name = name;
        return this;
    }
}
