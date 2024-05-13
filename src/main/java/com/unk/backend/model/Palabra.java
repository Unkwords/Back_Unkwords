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
@Entity
public class Palabra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String origen;
    @ElementCollection
    private List<String> significados;
    @ElementCollection
    private List<String> ejemplos;
    @ElementCollection
    private List<String> sinonimos;
    @ElementCollection
    private List<String> antonimos;
    private int numLikes;
}
