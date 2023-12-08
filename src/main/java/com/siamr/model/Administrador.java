package com.siamr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administrador")

public class Administrador {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column (name = "id", unique = true, nullable = false)
	private Long id;
	@Column (nullable = false)
	private String nombre;
	@Column (nullable = false)
	private String email;
	@Column (nullable = false)
	private String telefono;
	@Column (nullable = false)
	private String contraseña;
	
	public Administrador(String nombre, String email, String telefono, String contraseña) {
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.contraseña = contraseña;
	} // constructor
	
		public Administrador() {
			} // constructor vacio ID
	

				public Long getId() {
					return id;
				}


				public String getNombre() {
					return nombre;
				}
			
				public void setNombre(String nombre) {
					this.nombre = nombre;
				}
			
				public String getEmail() {
					return email;
				}
			
				public void setEmail(String email) {
					this.email = email;
				}
			
				public String getTelefono() {
					return telefono;
				}
			
				public void setTelefono(String telefono) {
					this.telefono = telefono;
				}
			
				public String getContraseña() {
					return contraseña;
				}
			
				public void setContraseña(String contraseña) {
					this.contraseña = contraseña;
				}


@Override
public String toString() {
return "Administrador [Id=" + id + ", nombre=" + nombre + ", email=" + email + ", telefono="
+ telefono + ", contraseña=" + contraseña + "]";
} // ToString


	
} // class
