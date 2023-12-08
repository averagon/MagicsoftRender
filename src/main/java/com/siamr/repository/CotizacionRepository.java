package com.siamr.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.siamr.model.Cotizacion;

@Repository
public interface CotizacionRepository extends JpaRepository <Cotizacion, Long> { // JPA: Java Persistence API
	Optional<Cotizacion> findByNombre(String nombre);

}
