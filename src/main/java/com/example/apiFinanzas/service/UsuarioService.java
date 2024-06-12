package com.example.apiFinanzas.service;

import com.example.apiFinanzas.model.Usuarios;
import com.example.apiFinanzas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuarios RegistrarUsuario(Usuarios usuario){
        return usuarioRepository.save(usuario); // save user
    }

    public List<Usuarios> ListarUsuarios(){
        return usuarioRepository.findAll(); // list user
    }

    public Usuarios ObtenerUsuario(Integer id){
        return usuarioRepository.findById(id).orElse(null); // find user by id
    }

    public void eliminarUsuario(Integer id){
        usuarioRepository.deleteById(id); // delete user by id
    }
}
