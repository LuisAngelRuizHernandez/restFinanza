package com.example.apiFinanzas.controller;

import com.example.apiFinanzas.model.Ingresos;
import com.example.apiFinanzas.service.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ingresos")
public class IngresoController {

    @Autowired
    private IngresoService ingresoService;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarIngreso(@RequestBody Ingresos ingreso) {
        ResponseEntity.ok(ingresoService.RegistrarIngresos(ingreso));
        return ResponseEntity.ok("Usuario registrado con éxito");
    }

            @GetMapping("/listar")
            public ResponseEntity<List<Ingresos>> listarIngresos() {
                return ResponseEntity.ok(ingresoService.listarIngresos());
            }
            @GetMapping("/{id}")
            public ResponseEntity<Ingresos> obtenerIngresoId(@PathVariable Integer id) {
                return ResponseEntity.ok(ingresoService.ObtenerIngreso(id));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarIngresoId(@PathVariable Integer id) {
        ingresoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}