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

import com.siamr.model.Cotizacion;
import com.siamr.service.CotizacionService;

@RestController
@RequestMapping(path="/api/cotizacion/") //http://localhost:8080/api/cotizacion/

public class CotizacionController {
	private final CotizacionService cotizacionService;
	
	@Autowired
	public CotizacionController(CotizacionService cotizacionService) {
		this.cotizacionService = cotizacionService;
	}//constructor
	
	@GetMapping 			//http://localhost:8080/api/cotizacion/
	public List<Cotizacion> getAllCotizaciones(){
		return cotizacionService.getAllCotizaciones();
	}//ArrayList
	
	@GetMapping (path= "{cotId}")			//http://localhost:8080/api/cotizaciones/1
	public Cotizacion getCotizacion(@PathVariable("cotId") long id) {
		return cotizacionService.getCotizacion(id);
	}//getCotizacion
	
	@DeleteMapping (path= "{cotId}")		//http://localhost:8080/api/cotizaciones/1
	public Cotizacion deleteCotizacion (@PathVariable("cotId") long id) {
		return cotizacionService.deleteCotizacion(id);
	}//deleteCotizacion
	
	@PostMapping 										//http://localhost:8080/api/cotizaciones/
	public Cotizacion addCotizacion(@RequestBody Cotizacion cotizacion){
		return cotizacionService.addCotizacion(cotizacion);
	}//deleteCotizacion
	
	@PutMapping (path= "{cotId}")						//http://localhost:8080/api/cotizaciones/1
	public Cotizacion updateCotizacion( @PathVariable("cotId") long id, 
			@RequestParam(required=false) String nombre,
			@RequestParam(required=false) String email,
			@RequestParam(required=false) String telefono,
			@RequestParam(required=false) String empresa,
			@RequestParam(required=false) String mensaje){
		return cotizacionService.updateCotizacion(id, nombre, email, telefono, empresa, mensaje);
	}//updateCotizacion
	
}//CotizacionController
