package com.project.cartegrise.partieexterne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cartegrise.partieexterne.models.Demande;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DemandeRepository extends JpaRepository<Demande,Long> {

    @Query(value = "SELECT d.id as did,d.date_demande,d.description_etat,d.etat,d.type,d.administration_fk,d.citoyen_fk," +
            "       c.id as cid,c.adresse,c.id,c.code,c.date_naissance,c.email,c.lieu_naissance,c.nationalite,c.nom,c.prenom,c.profession,c.sexe,c.telephone " +
            "       FROM demandes as d " +
            "       INNER JOIN citoyens as c" +
            "       ON d.citoyen_fk = c.id " +
            "       AND c.code=:code", nativeQuery = true)
    Demande getDemandeByCode(@Param("code") String Code);
}