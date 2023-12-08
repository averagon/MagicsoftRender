package com.siamr.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siamr.model.Ventas;
import com.siamr.service.VentasServicios;





//CRUD - Create - Read - Update -Delete
//HTTP - POST  -  GET  -  PUT    - Delete
@RestController 
@RequestMapping (path = "/api/ventas/") //http://localhost:8080/api/ventas/

public class VentasController {
	
	private final VentasServicios ventasServicio;
	@Autowired
	public VentasController(VentasServicios ventasServicio) {
		this.ventasServicio = ventasServicio;
	}
	@GetMapping

    	public List<Ventas>  getAllVentas(){

    		
    		return ventasServicio.getAllVentas();
    	
    		
    	}//getAllVentas
	@GetMapping(path="{ventaId}")
	public Ventas getVenta(@PathVariable("ventaId") long id){
		return ventasServicio.getVenta(id);
	}
	
	@DeleteMapping(path="{ventaId}")
	public Ventas deleteVenta(@PathVariable("ventaId") long id){
		return ventasServicio.deleteVentas(id);
	}
	
	@PostMapping
	public Ventas addVenta(@RequestBody Ventas venta ){
		return ventasServicio.addVenta(venta);
	}
	
	// http://localhost:8080/api/ventas/1?precio=155000.89&fecha=21/11/23
	@PutMapping(path="{ventaId}")
	public Ventas updateVentas(@PathVariable("ventaId") long id,
			@RequestParam(required=false) Double precio,
			@RequestParam(required=false) String fecha)
			{
		return ventasServicio.updateVentas(id, precio, fecha);
	}
      
}//class VentasController

