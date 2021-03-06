package com.atsistemas;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsistemas.entidades.Cliente;
import com.atsistemas.persistencia.ClienteRepository;

public class Aplicacion {

	public static void main(String[] args) {

		ApplicationContext context =  new AnnotationConfigApplicationContext("com.atsistemas");
		
		ClienteRepository dao = context.getBean(ClienteRepository.class);
		
		List<Cliente> resultados = dao.findAll();
		
		//List<Cliente> resultados = dao.findByNombre("Victor");
		
		for (Cliente cliente : resultados) {
			System.out.println(cliente.getId() + cliente.getNombre());
		}
		
	}

}
