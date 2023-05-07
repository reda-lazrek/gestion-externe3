package com.project.cartegrise.partieexterne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cartegrise.partieexterne.models.Citoyen;

public interface CitoyenRepository extends JpaRepository<Citoyen, Long> {
    
}
