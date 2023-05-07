package com.project.cartegrise.partieexterne.services;

import java.util.List;

import com.project.cartegrise.partieexterne.repositories.AdministrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cartegrise.partieexterne.models.Administration;

@Service
public class AdministrationService implements AdministrationServiceInterface {

    @Autowired
    AdministrationRepository administrationRepository;

    @Override
    public List<Administration> findAll() {
        return administrationRepository.findAll();
    }

    @Override
    public Administration add(Administration administration) {
        return administrationRepository.save(administration);
    }

    @Override
    public Administration edit(Administration administration) {
        return null;
    }

    @Override
    public Administration delete(Administration administration) {
        return null;
    }
    


}
