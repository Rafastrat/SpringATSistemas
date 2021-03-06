package com.atsistemas.entidades;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lanzador {

	public static void main(String[] args) {
		// Instanciar el contenedor
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		Persona pedro = (Persona) context.getBean("Pedro");
		
		Persona maria = context.getBean("Maria", Persona.class);
		
		Persona juan = context.getBean("Juan", Persona.class);
		
		System.out.println("Pedro: " + pedro);
		System.out.println("Maria: " + maria);
		System.out.println("Juan: " + juan);
		
		Persona pedro1 = (Persona) context.getBean("Pedro");
		
		System.out.println("Pedro1: " + pedro1);
		
		Persona maria1 = context.getBean("Maria", Persona.class);
		
		System.out.println("Maria1: " + maria1);
		
		
	}

}
