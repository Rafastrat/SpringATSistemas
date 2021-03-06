package com.atsistemas;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
@ComponentScan("com.atsistemas.persistencia")
public class Configuracion {

	@Bean
	public NamedParameterJdbcTemplate template(DataSource dataSource){
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Bean
	public DataSource datasource(){
		BasicDataSource ds = new BasicDataSource();
		
		ds.setUrl("jdbc:derby://localhost:1527/Clientes;create=true");
		ds.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
		ds.setUsername("user");
		ds.setPassword("user");
		//ds.setDefaultCatalog("User");
		
		return ds;
	}
	
}
