package com.project.cartegrise.partieexterne.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cartegrise.partieexterne.models.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    Optional<Employe> findByCin(String cin);
}
