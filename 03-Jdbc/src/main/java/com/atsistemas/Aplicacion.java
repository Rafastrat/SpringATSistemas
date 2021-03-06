package com.atsistemas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atsistemas.entidades.Cliente;
import com.atsistemas.persistencia.ClienteDao;
import com.atsistemas.persistencia.JdbcClienteDao;

public class Aplicacion {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.atsistemas");
		
		ClienteDao dao = context.getBean(ClienteDao.class);
		
		dao.alta(new Cliente(1, "Victor"));
		dao.alta(new Cliente(2, "Juan"));
		
		Cliente clienteUno = dao.consultaPorPk(1);
		
		System.out.println(clienteUno.getNombre());
		
		((JdbcClienteDao)dao).baja(clienteUno);
		
		
	}

}
