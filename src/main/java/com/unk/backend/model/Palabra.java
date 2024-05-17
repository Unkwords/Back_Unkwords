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
@Entity(name = "palabras")
public class Palabra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String palabra;
    private String tipo;
    private String origen;
    @ElementCollection
    @CollectionTable(
            name = "significados_palabra",
            joinColumns = @JoinColumn(name = "palabra_id")
    )
    @Column(name="significado")
    private List<String> significados;
    @ElementCollection
    @CollectionTable(
            name = "ejemplos_palabra",
            joinColumns = @JoinColumn(name = "palabra_id")
    )
    @Column(name="ejemplo")
    private List<String> ejemplos;
    @ElementCollection
    @CollectionTable(
            name = "sinonimos_palabra",
            joinColumns = @JoinColumn(name = "palabra_id")
    )
    @Column(name="sinonimo")
    private List<String> sinonimos;
    @ElementCollection
    @CollectionTable(
            name = "antonimos_palabra",
            joinColumns = @JoinColumn(name = "palabra_id")
    )
    @Column(name="antonimo")
    private List<String> antonimos;
    private int numLikes;
}
