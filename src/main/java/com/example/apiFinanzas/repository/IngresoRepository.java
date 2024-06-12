package com.example.apiFinanzas.repository;

import com.example.apiFinanzas.model.Ingresos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngresoRepository extends JpaRepository<Ingresos,Integer> {
}
