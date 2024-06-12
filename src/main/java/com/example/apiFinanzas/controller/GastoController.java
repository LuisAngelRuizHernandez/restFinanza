package com.example.apiFinanzas.controller;

import com.example.apiFinanzas.model.Gastos;
import com.example.apiFinanzas.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gastos")
public class GastoController {

    @Autowired
    private GastoService gastoService;

    @PostMapping("/registrarGasto")
    public ResponseEntity<Gastos> registrarGasto(@RequestBody Gastos gasto){
        return ResponseEntity.ok(gastoService.RegistrarGasto(gasto));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Gastos>> listarGastos(){
        return ResponseEntity.ok(gastoService.listarGastos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gastos> obtenerGastoId(@PathVariable Integer id){
        return ResponseEntity.ok(gastoService.findByIdGasto(id));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarGastoId(@PathVariable Integer id){
        gastoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
