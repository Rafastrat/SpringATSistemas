package com.atsistemas;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import com.atsistemas.Factoria.Coche;

@Configuration
@ComponentScan(basePackages="com.atsistemas")

public class Configuracion {
	
	
	
	@Bean
	@Profile("Desarrollo")
	public Persona pedro(){
		return new Persona();
		//return new Persona("Pedro",maria());
	}
	
	/*@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Persona maria(){
		Persona maria = new Persona();
		maria.setNombre("Maria");
		maria.setPareja(null);
		return maria;
	}*/
	
	@Bean
	public Factoria factoria(){
		return new Factoria();
	}

	@Bean
	public Coche ferrari(){
		return factoria().fabricar();
	}
	
	@Bean
	public Singleton singleton(){
		return Singleton.getInstance();
	}
	
}
