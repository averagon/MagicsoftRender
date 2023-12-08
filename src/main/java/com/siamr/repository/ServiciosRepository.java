package com.siamr.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.siamr.model.Servicios;

@Repository
public interface ServiciosRepository extends JpaRepository <Servicios, Long> { // JPA: Java Persistence API
	Optional<Servicios> findByNombre(String nombre);

}
