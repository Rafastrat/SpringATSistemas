package com.atsistemas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Contrato {

	
	//Referencia a la dependencia
	private Persona persona;

	@Autowired
	//Inyeccion por contruccion (normalmente cuando existe la necesidad imperiosa de la dependencia para que el bean realice su trabajo)
	public Contrato(@Qualifier("pedro") Persona persona) {
		super();
		this.persona = persona;
	}

	public Persona getPersona() {
		return persona;
	}
	
	//Se puede programar la autoinyeccion por contructor o por setter
	//@Autowired
	//Inyeccion por setter
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Contrato [persona=" + persona.getNombre() + "]";
	}
	
	
	
	
	
}
