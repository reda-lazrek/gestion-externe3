package com.project.cartegrise.partieexterne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cartegrise.partieexterne.models.Demande;

public interface DemandeRepository extends JpaRepository<Demande,Long> {
    
}
