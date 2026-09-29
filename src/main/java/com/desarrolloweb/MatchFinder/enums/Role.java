package com.desarrolloweb.matchfinder.enums;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name; // Convención estándar: "ROLE_ADMIN", "ROLE_USER"
}
