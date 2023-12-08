package com.siamr.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siamr.model.Servicios;
import com.siamr.repository.ServiciosRepository;
@Service

public class ServiciosService {
	private final ServiciosRepository serviciosRepository;
	@Autowired
	public ServiciosService(ServiciosRepository serviciosRepository) {
		this.serviciosRepository=serviciosRepository;
		//lista.add(new Servicios ("Distribución de equipo de cómputo", "Equipo de cómputo centralizado y descentralizado. Infraestructura de redes y accesorios periféricos.","img1.pgn"));
		//lista.add(new Servicios("Distribución de licencias de software","Integramos nuestras soluciones con licencias de sistema operativo nivel enterprise (Windows, RHEL). Software de diseño gráfico, arquitectónico y de ingeniería (Autodesk, Adobe).","img2.pgn"));
		//lista.add(new Servicios("Servicios en la nube", "Servicios en la nube (Azure, AWS, Google Cloud)","img3.pgn"));
		//lista.add(new Servicios("Desarrollo de Software a la medida.","Utilizamos metodologías ágiles y alcanzamos un alto nivel de madurez de acuerdo con la certificación internacional CMMi DEV5.","img4.pgn"));
		//lista.add(new Servicios("Servicios finacieros. Arrendamiento","Esta es la estrategia ideal para la renovación constante de tu infraestructura de TI y amortizar el costo financiero de la inversión inicial.", "img5.pgn"));
		//lista.add(new Servicios("Servicios administrados.","Administramos y mantenemos tu red, almacenamiento de datos,seguridad informática, gestión de base de datos y soporte técnico.", "img6.pgn"));
		//lista.add(new Servicios("SLA", "Ofrecemos acuerdos de nivel de servicio SLA que garantizan un alto rendiminto y disponibilidad de los servicios","img7.png"));
		//lista.add(new Servicios("Diseño de arquitectura de sistemas", "Nos adaptamos a las necesirdades y presupuesto de tu organización para planificar estratégiicamente la infrestructura de IT, ya sea para cómputo entralizado o cómputo descentralizado", "img8.png"));
		//lista.add(new Servicios("Implementación de Software de caja", "Adaptamos software de tipo ERP y CRM a las necesidades de tu empresa", "img9.png"));
		//lista.add(new Servicios("Servicios administrativos", "junto con los servicios en la nube, le proveemos del servicio de administración desde su casa", "img10.png"));
	}//constructor
	
	public List<Servicios> getAllServicios() {
		return serviciosRepository.findAll();
	}//getAllServicios

	public Servicios getServicios(long id) {
		return serviciosRepository.findById(id).orElseThrow(
			    ()-> new IllegalArgumentException ("El Producto con el id [" + id
			      + "] no existe")
			    );
	}//getServicios

	public Servicios deleteServicios(long id) {
		Servicios serv=null;
		if(serviciosRepository.existsById(id)){
			serv=serviciosRepository.findById(id).get();
			serviciosRepository.deleteById(id);
		}
		return serv;
	}//deleteServicios

	public Servicios addServicios(Servicios servicios) {
		Optional<Servicios>tmpServ=serviciosRepository.findByNombre(servicios.getNombre());
		if(tmpServ.isEmpty()) {
			return serviciosRepository.save(servicios);
		}else {
			System.out.println("Ya existe el producto con el nombre ["
					+ servicios.getNombre()+ "]");
			return null;
		}
	}//addServicios

	public Servicios updateServicios(long id, String nombre, String descripcion, String imagen) {
		Servicios serv=null;
		
		if(serviciosRepository.existsById(id)) {
			serv=serviciosRepository.findById(id).get();
			if(nombre!=null)serv.setNombre(nombre);
			if(descripcion!=null)serv.setDescripcion(descripcion);
			if(imagen!=null)serv.setImagen(imagen);
			serviciosRepository.save(serv);
		}//existsById
		return serv;
	}//updateServicio
}
