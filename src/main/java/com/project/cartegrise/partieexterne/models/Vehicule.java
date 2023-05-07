package com.project.cartegrise.partieexterne.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicules")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    @Column(nullable = false, length = 15)
    private String modele;

    @Column(nullable = false, length = 15) 
    private String marque;

    @Column(nullable = false, length = 15)
    private String carburant;
    
    @Column(nullable = false, length = 15)
    private String puissance;

    @Column(nullable = false, length = 2)
    private Integer nb_place;

    @Column(nullable = false, length = 2)
    private Integer nb_cylindres;
    
    private Double ptac;
    
    @OneToOne
    @JoinColumn(name = "cartegise_fk")
    CarteGrise carteGrise;
}
