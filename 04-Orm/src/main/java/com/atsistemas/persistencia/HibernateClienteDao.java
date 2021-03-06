package com.atsistemas.persistencia;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atsistemas.entidades.Cliente;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class HibernateClienteDao implements ClienteDao {

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	private SessionFactory sessionFactory;
	
	public void alta(Cliente cliente) {
		sessionFactory.getCurrentSession().persist(cliente);
	}

	@Transactional(readOnly=true)
	public Cliente consultaPorPk(int pk) {
		/*Query<Cliente> query = sessionFactory.getCurrentSession().createQuery("from Cliente c where c.id = :id", Cliente.class);
		
		query.setParameter("id", pk);
		
		return query.getSingleResult();*/
		
		return sessionFactory.getCurrentSession().find(Cliente.class, pk);
		
		
		
	}

}
