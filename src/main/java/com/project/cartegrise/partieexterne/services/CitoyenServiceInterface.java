package com.project.cartegrise.partieexterne.services;

import com.project.cartegrise.partieexterne.models.Administration;
import com.project.cartegrise.partieexterne.models.Citoyen;

import java.util.List;

public interface CitoyenServiceInterface {

    public List<Citoyen> findAll();
    public Citoyen add(Citoyen citoyen);
    public Citoyen edit(Citoyen citoyen);
    public Citoyen delete(Citoyen citoyen);
}
