package com.example.apiFinanzas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Gastos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreGasto;
    private String fechaGasto;
    private int valorGasto;
    private String descripcionGasto;

    @ManyToOne
    @JoinColumn(name = "_ID")
    private Usuarios usuario;

    public Gastos() {
    }

    public Gastos(int id, String nombreGasto, String fechaGasto, int valorGasto, String descripcionGasto, Usuarios usuario) {
        this.id = id;
        this.nombreGasto = nombreGasto;
        this.fechaGasto = fechaGasto;
        this.valorGasto = valorGasto;
        this.descripcionGasto = descripcionGasto;
        this.usuario = usuario;
    }
}
