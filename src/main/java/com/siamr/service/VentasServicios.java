package com.siamr.service;


import java.util.List;
import java.util.Optional;

import com.siamr.model.Ventas;
import com.siamr.repository.VentasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class VentasServicios {
	
private final VentasRepository ventasRepository;
		
		
	@Autowired
		public VentasServicios(VentasRepository ventasRepository) {
		this.ventasRepository = ventasRepository;
//			lista.add(new Ventas (120000.00,"02/10/23"));
//			lista.add(new Ventas (75000.00,"12/10/23"));	
//			lista.add(new Ventas (85000.00,"12/10/23"));
//			lista.add(new Ventas (59000.99,"05/11/23"));
//			lista.add(new Ventas (250000.00,"06/11/23"));
//			lista.add(new Ventas (500000.00,"21/11/23"));
			
		}// constructor
		
		public List<Ventas> getAllVentas() {
			return ventasRepository.findAll();
		} // getAllVentas


		
		public Ventas getVenta(long id) {
			return ventasRepository.findById(id).orElseThrow(
			()-> new IllegalArgumentException ("La Venta con el id [" + id 
					+"] no existe")
			);


		} // getVenta


		public Ventas deleteVentas(long id) {
			Ventas vent = null;

			if (ventasRepository.existsById(id)) {
				vent=ventasRepository.findById(id).get(); 
					ventasRepository.deleteById(id);
					} // if existsById
			
			return vent;
		} // deleteVenta



		public Ventas addVenta(Ventas venta) {

			Optional <Ventas> tmpVent = ventasRepository.findByFecha(venta.getFecha());
			if (tmpVent.isEmpty()) { //No se encuentra el producto con ese nombre
			return ventasRepository.save(venta);
			} else {
				System.out.println("Ya existe el producto con el nombre ["
						+ venta.getFecha() + "]");
				return null;
				}//else

			
		} // addVenta


		public Ventas updateVentas(long id, Double precio, String fecha) {
			Ventas vent = null;

			
			if (ventasRepository.existsById(id))  {
				vent = ventasRepository.findById(id).get(); 
					if(precio!= null)vent.setPrecio(precio); 
					if(fecha!= null)vent.setFecha(fecha); 
					ventasRepository.save(vent);
					
					
				} // existsById

			
			return vent;
		} // updateVentas
		
	} // class


