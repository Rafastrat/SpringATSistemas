package com.cursospring.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cursospring.entidades.Cliente;
import com.cursospring.servicios.Servicio;

@Controller
@RequestMapping("/GestionUsuario")
public class Controlador {
	
	@Autowired
	private Servicio servicio;
	
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	//http://localhost:8080/09-Mvc/GestionUsuario?pepito=1
	@RequestMapping(method = RequestMethod.GET)
	public String alta(@RequestParam("pepito") int id, Cliente cliente, Model model, HttpServletRequest request){
		servicio.altaCliente(cliente);
		
		System.out.println(cliente.getNombre() + cliente.getId());
		
		model.addAttribute("resultado", "Se ha dado de alta correctamente el cliente");
		
		return "alta";
	}
	
	//http://localhost:8080/09-Mvc/GestionUsuario/12
	@RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
	public void baja(@PathVariable int id){
		servicio.bajaCliente();
	}

}
