package com.example.apiFinanzas.service;

import com.example.apiFinanzas.model.Ingresos;
import com.example.apiFinanzas.repository.IngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngresoService {

    @Autowired
    IngresoRepository ingresoRepository;

    // save
    public Ingresos RegistrarIngresos(Ingresos ingreso){
        return ingresoRepository.save(ingreso);
    }

    // listar
    public List<Ingresos> listarIngresos(){
        return ingresoRepository.findAll();
    }

    // find user by id
    public Ingresos ObtenerIngreso(Integer id){
        return ingresoRepository.findById(id).orElse(null);
    }

    // delete by id
    public void deleteById(Integer id){
        ingresoRepository.deleteById(id); // delete by id
    }
}
