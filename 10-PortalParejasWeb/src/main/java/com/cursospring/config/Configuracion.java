package com.cursospring.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("com.cursospring")
@EnableJpaRepositories("com.cursospring.modelo.persistencia")
@EnableWebMvc
public class Configuracion {

	//Beans necesarios para trabajar con Spring Mvc
	
	@Bean
	public RequestMappingHandlerMapping defaultAnnotationHandlerMapping(){
		return new RequestMappingHandlerMapping();
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
	
	//Beans necesarios para trabajar con Spring Data Jpa
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setPackagesToScan("com.cursospring.modelo.entidades");
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		Map<String, String> propiedades = new HashMap<>();
		propiedades.put("hibernate.hbm2ddl.auto", "create");
		factoryBean.setJpaPropertyMap(propiedades );
		return factoryBean;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf){
		return new JpaTransactionManager(emf);
	}
	
	@Bean
	public DataSource dataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
		ds.setUrl("jdbc:derby://localhost:1527/Clientes;create=true");
		ds.setUsername("user");
		ds.setPassword("user");
		
		return ds;
	}
	
}
