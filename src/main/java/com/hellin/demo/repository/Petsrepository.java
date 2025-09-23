package com.hellin.demo.repository;

import com.hellin.demo.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Petsrepository extends JpaRepository<Pet, Long> {



}
