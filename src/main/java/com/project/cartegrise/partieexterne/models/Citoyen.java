package com.project.cartegrise.partieexterne.models;

import java.sql.Date;
import java.util.*;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "citoyens")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Citoyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    @Column(nullable = false, length = 30)
    private String nom;

    @Column(nullable = false, length = 30)
    private String prenom;

    @Column(nullable = false, length = 1)
    private Character sexe;
    
    private Date date_naissance;
    
    @Column(nullable = false, length = 10)
    private String lieu_naissance;

    @Column(nullable = false, length = 10, unique = true)
    private String cin;
    
    private String adresse;
    
    @Column(length = 15)
    private String telephone;

    @Column(length = 20)
    private String nationalite;

    @Column(length = 20)
    private String profession;

    @Column(length = 10)
    private String code;

    @Column(length = 30)
    private String email;
    
    @OneToMany
    private List<CarteGrise> cartegrises = new ArrayList<>();
    
    @OneToMany
    private List<Demande> demandes = new ArrayList<>();
    
}
