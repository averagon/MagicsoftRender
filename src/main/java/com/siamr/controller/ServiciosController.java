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

import com.siamr.model.Servicios;
import com.siamr.service.ServiciosService;

//@CrossOrigin(origins="*")
@RestController
@RequestMapping(path="/api/servicios/")//http://localhost:8080/api/servicios/

public class ServiciosController {
	private final ServiciosService serviciosService;
	@Autowired
	public ServiciosController(ServiciosService serviciosService) {
		this.serviciosService = serviciosService;
	}//constructor


@GetMapping
public List<Servicios> getAllServicios(){
	return serviciosService.getAllServicios();
}//getAllServicios

@GetMapping(path="{servID}")
public Servicios getServicios(@PathVariable("servID")long id){
	return serviciosService.getServicios(id);
}//getServicios

@DeleteMapping(path="{servID}")
public Servicios deleteServicios(@PathVariable("servID")long id){
	return serviciosService.deleteServicios(id);
}//deleteServicios

@PostMapping
public Servicios addServicios(@RequestBody Servicios servicios){
	return serviciosService.addServicios(servicios);
}//addAllProductos

@PutMapping(path="{servID}")
public Servicios updateServicios(@PathVariable("servID")long id,
		@RequestParam(required=false)String nombre,
		@RequestParam(required=false)String descripcion,
		@RequestParam(required=false)String imagen){
	return serviciosService.updateServicios(id,nombre,descripcion,imagen);
}//updateServicios

}//class