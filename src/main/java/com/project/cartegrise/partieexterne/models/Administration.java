package com.project.cartegrise.partieexterne.models;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;


@Entity
@Table(name = "administrations")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Administration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    @Column(nullable = false, length = 50)
    @NotNull(message = "Le champ Nom est obligatoire")
    private String nom;
    
    private String adresse;
    
    @Column(length = 15)
    private String telephone;
    
    @OneToMany
    private List<Demande> demandes = new ArrayList<>();
    
    @OneToMany
    private List<Employe> employees = new ArrayList<>();

}
