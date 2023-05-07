package com.project.cartegrise.partieexterne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cartegrise.partieexterne.models.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    
}
