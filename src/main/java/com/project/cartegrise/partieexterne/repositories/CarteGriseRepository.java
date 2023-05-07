package com.project.cartegrise.partieexterne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cartegrise.partieexterne.models.CarteGrise;

public interface CarteGriseRepository extends JpaRepository<CarteGrise, Long> {
    
}
