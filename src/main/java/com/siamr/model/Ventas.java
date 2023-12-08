package com.siamr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ventas")

public class Ventas {
	@Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 @Column (name = "id", unique = true, nullable = false)
	private Long Id;
	@Column (nullable = false)
	private Double precio;
	@Column (nullable = false)
	private String fecha;
	
	

	public Ventas(Double precio, String fecha) {
		this.precio = precio;
		this.fecha = fecha;
		
	} // constructor
	
	public Ventas() {
		
		} // constructor2

	public Long getId() {
		return Id;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
	
	@Override
	public String toString() {
		return "Ventas [Id=" + Id + ", precio=" + precio + ", fecha=" + fecha + "]";
	} //toString
	
	
	
	
	
	
	

} // class
