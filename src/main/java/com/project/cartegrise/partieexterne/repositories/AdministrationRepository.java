package com.project.cartegrise.partieexterne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cartegrise.partieexterne.models.Administration;

public interface AdministrationRepository extends JpaRepository<Administration, Long> {
    
}
