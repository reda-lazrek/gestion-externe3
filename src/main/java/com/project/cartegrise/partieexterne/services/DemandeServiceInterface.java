package com.project.cartegrise.partieexterne.services;

import com.project.cartegrise.partieexterne.models.Administration;
import com.project.cartegrise.partieexterne.models.Demande;
import com.project.cartegrise.partieexterne.models.Document;

import java.util.List;

public interface DemandeServiceInterface {
    List<Demande> findAll();
     Demande add(Demande demande);
     Demande edit(Demande demande);
     Demande delete(Demande demande);
}
