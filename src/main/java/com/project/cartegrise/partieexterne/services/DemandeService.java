package com.project.cartegrise.partieexterne.services;

import com.project.cartegrise.partieexterne.models.Administration;
import com.project.cartegrise.partieexterne.models.Citoyen;
import com.project.cartegrise.partieexterne.models.Demande;
import com.project.cartegrise.partieexterne.repositories.AdministrationRepository;
import com.project.cartegrise.partieexterne.repositories.CitoyenRepository;
import com.project.cartegrise.partieexterne.repositories.DemandeRepository;
import com.project.cartegrise.partieexterne.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DemandeService implements DemandeServiceInterface{


    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private AdministrationRepository administrationRepository;

    @Autowired
    private CitoyenRepository citoyenRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public List<Demande> findAll() {
        return demandeRepository.findAll();
    }

    @Override
    public Demande add(Demande demande) {
        Administration administration= administrationRepository.findAll().get(0);
        demande.setAdministration(administration);
        citoyenRepository.save(demande.getCitoyen());
//        documentRepository.save(demande.getDocuments().get(0));
        return demandeRepository.save(demande);
    }

    @Override
    public Demande edit(Demande demande) {
       return demandeRepository.save(demande);
    }

    @Override
    public Demande delete(Demande demande) {
        return null;
    }

    @Override
    public Demande getDemandeByCode(String code) {
        return demandeRepository.getDemandeByCode(code);
    }
}
