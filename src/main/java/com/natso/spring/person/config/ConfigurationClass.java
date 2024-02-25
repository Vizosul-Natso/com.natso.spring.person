package com.natso.spring.person.config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan(basePackages = "com.natso.spring" )
public class ConfigurationClass{
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/Views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	@Bean
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("natso").createEntityManager();
		
	}

}
