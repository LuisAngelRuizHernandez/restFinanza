package com.example.apiFinanzas.repository;

import com.example.apiFinanzas.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuarios,Integer> {
    Usuarios findByCorreo(String correo); // buscar correo
}
