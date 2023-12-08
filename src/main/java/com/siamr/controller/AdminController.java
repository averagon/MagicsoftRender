package com.siamr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siamr.model.Administrador;
import com.siamr.model.ChangePassword;
import com.siamr.service.AdministradorServicios;

@RestController
@RequestMapping(path="/api/administrador/") //  http://localhost:8080/api/administrador/
public class AdminController {
	private final AdministradorServicios administradorServicios;
	
	@Autowired
	public AdminController(AdministradorServicios administradorServicios) {
		this.administradorServicios= administradorServicios;
	}


	@GetMapping //  http://localhost:8080/api/administrador/
	public List<Administrador> getAllAdmin () {
		return administradorServicios.getAllAdministrador();
	}
	
	@GetMapping(path="{adminId}") //http://localhost:8080/api/administrador/1
	public Administrador getAdministrador (@PathVariable ("adminId") long id) {
		return administradorServicios.getAdministrador(id);
	}//getAdministrador
	
	@DeleteMapping(path="{adminId}") //  http://localhost:8080/api/administrador/1
	public Administrador deleteAdministrador (@PathVariable ("adminId") long id) {
		return administradorServicios.deleteAdministrador(id);
	}//deleteAdministrador
	
	@PostMapping  //  http://localhost:8080/api/administrador/
	public Administrador addAdministrador(@RequestBody Administrador administrador) {
		return administradorServicios.addAdministrador(administrador);
	}
	
	@PutMapping(path="{adminId}") //  http://localhost:8080/api/administrador/8?email=calmatePiojosa@gmail.com
	public Administrador updateAdministrador(@PathVariable ("adminId") long id, 
			@RequestBody ChangePassword changePassword) {
		return administradorServicios.updateAdministrador(id, changePassword);
	}
	

	
	
	
	
}//class AdministradorController