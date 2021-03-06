package com.atsistemas.persistencia.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atsistemas.entidades.Cliente;
import com.atsistemas.persistencia.ClienteDao;

@Repository
@Transactional(propagation= Propagation.REQUIRED)
public class JpaClienteDao implements ClienteDao {

	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void alta(Cliente cliente) {
		em.persist(cliente);
	}

	@Transactional(readOnly=true)
	public Cliente consultaPorPk(int pk) {
		return em.find(Cliente.class, pk);
	}

}
