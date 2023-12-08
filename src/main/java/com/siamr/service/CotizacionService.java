package com.siamr.service;

import com.siamr.model.Cotizacion;
import com.siamr.repository.CotizacionRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CotizacionService {

	public final CotizacionRepository cotizacionRepository;
	
	@Autowired
	public CotizacionService(CotizacionRepository cotizacionRepository) {
		this.cotizacionRepository = cotizacionRepository;
		//lista.add(new Cotizacion("Verónica Castro","verocastro@mail.com","2356987412","Vero sa de cv","Quiero unos servicios en la nube"));
		//lista.add(new Cotizacion("Amalia Quinteros","amalia@mail.com","6598742355","Amalia sa de cv","Equipo de cómputo centralizado y descentralizado"));
		//lista.add(new Cotizacion("Luis Miguel","luis@mail.com","6658974451","Luis sa de cv","Distribución de licencias de software"));
		//lista.add(new Cotizacion("Amanda Miguel","amanda@mail.com","6598256633","Amanda sa de cv","Servicios administrativos"));
		//lista.add(new Cotizacion("Benito Juárez","benito@mail.com","6699856655","Benito sa de cv","Implementación de Software de Caja"));
		//lista.add(new Cotizacion("Verónica Castro","verocastro@mail.com","2356987412","Vero sa de cv","Servicios Administrativos de la OnSite"));
	}//constructor CotizacionService
	
	public List<Cotizacion> getAllCotizaciones(){
		return cotizacionRepository.findAll();
	}//getAllCotizaciones
	
	public Cotizacion getCotizacion (long id) {
		return cotizacionRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException ("El producto con el id [" + id
						+ "] no existe")
				);	
	}//getCotizacion
	
	public Cotizacion deleteCotizacion (long id) {
		Cotizacion cot=null;
		if (cotizacionRepository.existsById(id)) {
			cot=cotizacionRepository.findById(id).get();
		}//if
		return cot;
	}//deleteCotizacion
	
	public Cotizacion addCotizacion (Cotizacion cotizacion) {
		//TODO: Validación
		Optional<Cotizacion> tmCot= cotizacionRepository.findByNombre(cotizacion.getNombre());
		if (tmCot.isEmpty() ) {
			return cotizacionRepository.save(cotizacion);
		} else {
			System.out.println("Ya existe el producto con el nombre [" +cotizacion.getNombre()
					+ "]");
			return null;
		}//else
	}//addCotizacion
	
	public Cotizacion updateCotizacion (long id, String nombre, String email, String telefono, String empresa, String mensaje) {
		Cotizacion cot = null;
		if (cotizacionRepository.existsById(id)) {
			cot = cotizacionRepository.findById(id).get();
			if (nombre!=null) cot.setNombre(nombre);
			if (email!=null) cot.setEmail(email);
			if (telefono!=null) cot.setTelefono(telefono);
			if (empresa!=null) cot.setEmpresa(empresa);
			if (mensaje!=null) cot.setMensaje(mensaje);
			cotizacionRepository.save(cot);
		}//existById
		return cot;
	}//updateCotizacion
	
	
}//class CotizacionesService
