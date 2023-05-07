package com.project.cartegrise.partieexterne.models;

import java.sql.Date;
import java.util.Collection;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;

@Entity
@Table(name = "employes")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employe implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;
    
    @Column(nullable = false, length = 30)
    private String nom;

    @Column(nullable = false, length = 30)
    private String prenom;

    private Date date_naissance;

    @Column(nullable = false, length = 10, unique = true)
    private String cin;

    @Column(nullable = false, length = 30)
    private String mot_de_passe;
    
    @ManyToOne
    @JoinColumn(name="administration_fk")
    private Administration administration;

    
    
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    @Override
    public String getPassword() {
        return mot_de_passe;
    }
    @Override
    public String getUsername() {
        return cin;
    }
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
