package com.project.cartegrise.partieexterne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cartegrise.partieexterne.models.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    
}
