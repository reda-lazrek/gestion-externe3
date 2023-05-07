package com.project.cartegrise.partieexterne.services;

import java.util.List;

import com.project.cartegrise.partieexterne.models.Administration;

public interface AdministrationServiceInterface {
    public List<Administration> findAll();
    public Administration add(Administration administration);
    public Administration edit(Administration administration);
    public Administration delete(Administration administration);
}
