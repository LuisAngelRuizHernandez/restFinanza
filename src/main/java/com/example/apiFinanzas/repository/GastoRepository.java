package com.example.apiFinanzas.repository;

import com.example.apiFinanzas.model.Gastos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository<Gastos, Integer> {
}
