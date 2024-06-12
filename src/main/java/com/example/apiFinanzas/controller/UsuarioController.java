package com.example.apiFinanzas.controller;

import com.example.apiFinanzas.model.Usuarios;
import com.example.apiFinanzas.repository.UsuarioRepository;
import com.example.apiFinanzas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository; // inyectar el repository

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuarios usuario){
        ResponseEntity.ok(usuarioService.RegistrarUsuario(usuario));
        return ResponseEntity.ok("Usuario registrado con éxito");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuarios>> listarUsuario(){
        return ResponseEntity.ok(usuarioService.ListarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> obtenerUsuario(@PathVariable Integer id){
        return ResponseEntity.ok(usuarioService.ObtenerUsuario(id));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id){
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    // validar el login del usuario
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuarios usuario) {
        // Lógica para validar el usuario
        boolean valid = validarUsuario(usuario.getCorreo(), usuario.getPassword());
        if(valid) {
            return ResponseEntity.ok("Login exitoso");
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
        // validar el usuario
    private boolean validarUsuario(String correo, String password) {
        Usuarios usuario = usuarioRepository.findByCorreo(correo); // usar el metodo del repository findByCorreo
        return usuario != null && usuario.getPassword().equals(password); // validar credenciales
    }
}
