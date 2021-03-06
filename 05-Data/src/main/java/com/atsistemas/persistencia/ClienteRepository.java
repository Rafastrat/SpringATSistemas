package com.atsistemas.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atsistemas.entidades.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	//SELECT * FROM Cliente WHERE nombre = :nombre
	public List<Cliente> findByNombre(String nombre);
	
	@Query("select c from Cliente c where c.id = :id")
	public List<Cliente> meDaIgualEstoEsUnaConsulta(int id);
	
}
