package com.siamr.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.siamr.model.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository <Administrador, Long> {
	//Optional<Administrador> findByNombre(String nombre);
	Optional<Administrador> findByEmail(String email);
	

}
