package com.p5.adoptions.repository.animal;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer>
{
    Optional<Animal> findByName(String name);
}
