package com.natso.spring.person.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.natso.spring.person.entity.Person;

@Component
public class PersonDao {

	@Autowired
	private EntityManager entityManager ;
	
	public void savePerson(Person person) {
		
		EntityTransaction transaction = entityManager.getTransaction() ;
		transaction.begin();
		entityManager.persist(person);
		transaction.commit();
//		entityManager.close();
	}
	
	public Person findPerson(int id) {
			return entityManager.find(Person.class, id) ;
	}
	
	public boolean deletePerson(int id) {
		
		Person person = findPerson(id) ;
		
		if (person != null) {
			EntityTransaction transaction = entityManager.getTransaction() ;
			transaction.begin();
			entityManager.remove(person);
			transaction.commit();
			entityManager.close();
			return true ;
		}
		return false ;
		
	}
	
	public void updatePerson(Person person) {
		
		EntityTransaction transaction = entityManager.getTransaction() ;
		transaction.begin();
		entityManager.merge(person) ;
		transaction.commit();
	}
	
	public List<Person> displayAll() {
		
		Query query = entityManager.createQuery("from Person") ;
		
		List list = query.getResultList() ;
		
		return list ;
				
	}
}