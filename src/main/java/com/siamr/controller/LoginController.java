package com.siamr.controller;

import javax.servlet.ServletException;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siamr.config.JwtFilter;
import com.siamr.model.Administrador;
import com.siamr.model.Token;
import com.siamr.service.AdministradorServicios;

import java.util.Calendar;
import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

	@RestController
	@RequestMapping (path="/api/login/")
	public class LoginController {
		private final AdministradorServicios administradorServicios;

		@Autowired
		public LoginController(AdministradorServicios administradorServicios) {
			this.administradorServicios = administradorServicios;
		}//constructor
		
		@PostMapping
		public Token loginUsuario(@RequestBody Administrador administrador)throws ServletException {
			if(administradorServicios.validateAdministrador(administrador)) {
				System.out.println("usuario válido " + administrador.getEmail());
				return new Token(generateToken(administrador.getEmail()));
			}//if
			throw new ServletException("Nombre de usuario o contraseña incorrectos");
		}//loginUsuario
		
		private String generateToken(String username) {
			Calendar calendar = Calendar.getInstance();//Fecha hora actual
			calendar.add(Calendar.HOUR, 10); // Pruebas
			//calendar.add(Calendar.MINUTE, 30);// Producción
			return Jwts.builder().setSubject(username).claim("role", "user")
			.setIssuedAt(new Date())
			.setExpiration(calendar.getTime())
			.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
			.compact();
		}//generateToken
		
		
		
		
		
	}//class LoginController


