package com.cursospring.modelo.negocio.basico;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cursospring.modelo.entidades.Usuario;

public class BasicasReglasAfinesTest {

	@Test(expected=NullPointerException.class)
	public void pruebaCuandoAlgunoDeLosUsuariosEsNulo() {
		
		//Inicializacion
		//	Sut
		BasicasReglasAfines sut = new BasicasReglasAfines();
		//	Datos de entrada
		Usuario elQueBusca = null;
		Usuario candidato = null;
		//	Datos Esperados (no que hay definirlo porque se hace con la anotación)
		
		//Ejecutar la funcionalidad
		sut.sonAfines(elQueBusca, candidato);
		
		//Validacion de los resultados (no que hay definirlo porque se hace con la anotación)
		
		
		fail("No se lanzo la excepcion");
	}

}
