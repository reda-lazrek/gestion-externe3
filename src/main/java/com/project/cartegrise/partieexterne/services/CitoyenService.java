package com.project.cartegrise.partieexterne.services;

import com.project.cartegrise.partieexterne.models.Citoyen;
import com.project.cartegrise.partieexterne.repositories.CitoyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitoyenService implements CitoyenServiceInterface{

    @Autowired
    private CitoyenRepository citoyenRepository;

    @Override
    public List<Citoyen> findAll() {
        return citoyenRepository.findAll();
    }

    @Override
    public Citoyen add(Citoyen citoyen) {
        return citoyenRepository.save(citoyen);
    }

    @Override
    public Citoyen edit(Citoyen citoyen) {
        return null;
    }

    @Override
    public Citoyen delete(Citoyen citoyen) {
        return null;
    }
}
