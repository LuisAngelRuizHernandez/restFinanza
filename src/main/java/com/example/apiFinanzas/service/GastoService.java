package com.example.apiFinanzas.service;

import com.example.apiFinanzas.model.Gastos;
import com.example.apiFinanzas.repository.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoService {

    @Autowired
    GastoRepository gastoRepository;

    // register
    public Gastos RegistrarGasto(Gastos gasto){
        return gastoRepository.save(gasto); // save
    }

    // list get
    public List<Gastos> listarGastos(){
        return gastoRepository.findAll(); // listar gastos
    }

    // find by id
    public Gastos findByIdGasto(Integer id){
        return gastoRepository.findById(id).orElse(null);
    }

    //delete by id
    public void deleteById (Integer id){
        gastoRepository.deleteById(id); // delete
    }

}
