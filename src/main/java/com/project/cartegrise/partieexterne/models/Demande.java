package com.project.cartegrise.partieexterne.models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;


@Entity
@Table(name = "demandes")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    @Column(nullable = false, length = 50)
    private String type;

    @Column(nullable = false)
    private Date date_demande = Date.valueOf(LocalDate.now());

    @Column(nullable = false, length = 2)
    private String etat = "O";


    private String description_etat;
    
    @ManyToOne
    @JoinColumn(name="citoyen_fk")
    private Citoyen citoyen;
    
    @OneToMany
    private List<Document> documents = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name="Administration_fk")
    private Administration administration;


}
