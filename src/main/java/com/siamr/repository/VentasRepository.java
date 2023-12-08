package com.siamr.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.siamr.model.Ventas;

@Repository
public interface VentasRepository extends JpaRepository <Ventas, Long> {
 Optional<Ventas> findByFecha(String fecha);

}
