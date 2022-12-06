package com.groupeuisi.ParcInfo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 150)
    private String prenom;
    @Column(nullable = false, length = 150)
    private String nom;
    @Column(nullable = false, length = 150)
    private String email;
    @Column(nullable = false, length = 150)
    private String psw;
    private int etat;
    @ManyToMany
    private List<AppRoleEntity> appRoleEntity;
}
