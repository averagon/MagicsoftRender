package com.siamr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.siamr.config.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;



@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}// MAIN

	
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter(){
		FilterRegistrationBean<JwtFilter> registrationBean = 
							new FilterRegistrationBean<>();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/servicios/*");
	registrationBean.addUrlPatterns("/api/administrador/*");
		return registrationBean;
	}//jwtFilter

} // class BackendApplication


