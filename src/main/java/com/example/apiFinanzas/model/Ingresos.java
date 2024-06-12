package com.example.apiFinanzas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Ingresos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String nombre;
    private int valor;
    private String fuente;
    private String descripcion;

    // ingreso de la columna fk
    @ManyToOne
    @JoinColumn(name = "_ID")
    private Usuarios usuario;

    public Ingresos() {
    }

    public Ingresos(int ID, String nombre, int valor, String fuente, String descripcion, Usuarios usuario) {
        this.ID = ID;
        this.nombre = nombre;
        this.valor = valor;
        this.fuente = fuente;
        this.descripcion = descripcion;
        this.usuario = usuario;
    }
}
