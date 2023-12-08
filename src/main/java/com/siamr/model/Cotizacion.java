package com.siamr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "cotizacion")
public class Cotizacion {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String telefono;
	@Column(nullable=false)
	private String empresa;
	@Column(nullable=false)
	private String mensaje;


	//1. Constructor
	public Cotizacion(String nombre, String email, String telefono, String empresa, String mensaje) {
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.empresa = empresa;
		this.mensaje = mensaje;
		
	}//constructor
	
	public Cotizacion() {

	}//constructor

	//2. Getters and setters (encapsular)
			public String getNombre() {
				return nombre;
			}//getNombre
		
			public void setNombre(String nombre) {
				this.nombre = nombre;
			}//setNombre
		
			public String getEmail() {
				return email;
			}//getEmail
		
			public void setEmail(String email) {
				this.email = email;
			}//setEmail
		
			public String getTelefono() {
				return telefono;
			}//getTelefono
		
			public void setTelefono(String telefono) {
				this.telefono = telefono;
			}//setTelefono
		
			public String getEmpresa() {
				return empresa;
			}//getEmpresa
		
			public void setEmpresa(String empresa) {
				this.empresa = empresa;
			}//setEmpresa
		
			public String getMensaje() {
				return mensaje;
			}//getMensaje
		
			public void setMensaje(String mensaje) {
				this.mensaje = mensaje;
			}//setMensaje
		
			public Long getId() {
				return id;
			}//getId
			
			
	//3. toString

			@Override
			public String toString() {
				return "Cotizaciones [id=" + id + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono
						+ ", empresa=" + empresa + ", mensaje=" + mensaje + "]";
			}//toString	
	
}//class Cotizaciones
