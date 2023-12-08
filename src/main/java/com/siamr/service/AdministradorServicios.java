package com.siamr.service;

import java.util.List;
import java.util.Optional;

import com.siamr.model.Administrador;
import com.siamr.model.ChangePassword;
import com.siamr.repository.AdministradorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class AdministradorServicios {
	
	private final AdministradorRepository administradorRepository; 
	
	@Autowired
	private PasswordEncoder passwordEncoder;
		
@Autowired
	public AdministradorServicios(AdministradorRepository administradorRepository) {
		this.administradorRepository = administradorRepository;
	}// constructor

				//lista.add(new Administrador ("Karen Valenzuela","karen.tupatrona@gmail.com", "3311756441", "corazonValiente@123"));
				//lista.add(new Administrador ("Sandra Meraz","todosOdiamosAsandra@gmail.com", "6181066180", "laRompecorazones69@"));	
				//lista.add(new Administrador ("Angela Vera","nosoyVelaEntiende@gmail.com", "8712618563", "quieroDormir@12"));
				//lista.add(new Administrador ("Fabiola Valdes","lacomeTacos@gmail.com", "3339503490", "taquitos4Ever@"));
				//lista.add(new Administrador ("Ingrid Romero","IngridPiojosa@gmail.com","5531024561", "Piojos123@"));
				//lista.add(new Administrador ("Jazmin Rodriguez","jazzz_conejito@gmail.com","5548142468", "conejitos4Ever@"));
				//lista.add(new Administrador ("Carolina Ayala","noMellamoCONSUELO@gmail.com", "8662075674", "Nosoyconsuelo@"));
				//lista.add(new Administrador ("Ana Sanchez","todosMeaman@gmail.com", "8332954201", "todosMeaman123@"));
	
	public List<Administrador> getAllAdministrador() {
		return administradorRepository.findAll();
	} // getAllAdministrador


	public Administrador getAdministrador(long id) {
		return administradorRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException ("El Producto con el id [" + id
						+ "] no existe")
				);
	} // getAdministrador
		
	public Administrador deleteAdministrador(long id) {
		Administrador admin = null;
		if(administradorRepository.existsById(id)){
			admin=administradorRepository.findById(id).get();
			administradorRepository.deleteById(id);
		} // if existsById
	return admin;
} // deleteAdministrador



	public Administrador addAdministrador(Administrador administrador) {
		Administrador admin = null;
		if  (administradorRepository.findByEmail(administrador.getEmail()).isEmpty())  {
			//Cifrar la contraseña
			administrador.setContraseña( passwordEncoder.encode(administrador.getContraseña()) );
			admin = administradorRepository.save(administrador);
		} else{
			System.out.println("El usuario con el email [" + administrador.getEmail()	+ "] ya se encuentra registrado");
		}//if isEmpty
		return admin;
	} // addAdministrador


	public Administrador updateAdministrador(Long id, ChangePassword changePassword) {
		Administrador admin = null;
		if (administradorRepository.existsById(id)) {
			admin = administradorRepository.findById(id).get();
			if(passwordEncoder.matches(changePassword.getContraseña(),admin.getContraseña())) {
				admin.setContraseña(passwordEncoder.encode(changePassword.getNewContraseña()));
				administradorRepository.save(admin);
			}else {
				System.out.println("updateUser - La contraseña es incorrecta id[" + id
						+ "]");
				admin =null;
			}//if equals
		} else {
			System.out.println("updateUser - El usuario con el id[" + id
					+ "] NO se encuentra registrado");
		}//else //if existById
		return admin;
	}//updateAdministrador
		

	public boolean validateAdministrador(Administrador administrador) {
		Optional<Administrador> userByEmail = administradorRepository.findByEmail(administrador.getEmail()); 
		if (userByEmail.isPresent()) {
			Administrador admin = userByEmail.get();
			if(passwordEncoder.matches(administrador.getContraseña(),admin.getContraseña())) {
				return true;
			}//if password equals
		}//if isPresent
		return false;
	}//validateUser
			
} // class
