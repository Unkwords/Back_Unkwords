package com.unk.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String contrasena;
    @Column(unique = true)
    private String username;
    private String email;
    @OneToMany
    @JoinTable(name = "palabras_subidas_usuario")
    private List<Palabra> palabrasSubidas;
    @OneToMany
    @JoinTable(name = "palabras_favoritas_usuario")
    private List<Palabra> palabrasFavoritas;
    @Enumerated(EnumType.STRING)
    private Role role;
}
