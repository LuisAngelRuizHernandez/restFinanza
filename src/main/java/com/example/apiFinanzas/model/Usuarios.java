package com.example.apiFinanzas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int _ID;
    private String nombre;
    private String apellido;
    private String password;
    private String correo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true) // Cambiar a "usuario"
    private List<Ingresos> ingresos;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true) // Cambiar a "usuario"
    private List<Gastos> gastos;

    public Usuarios() {
    }

    public Usuarios(int _ID, String nombre, String apellido, String password, String correo, List<Ingresos> ingresos, List<Gastos> gastos) {
        this._ID = _ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.correo = correo;
        this.ingresos = ingresos;
        this.gastos = gastos;
    }
}
