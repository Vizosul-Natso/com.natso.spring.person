package com.natso.spring.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natso.spring.person.dao.PersonDao;
import com.natso.spring.person.entity.Person;

@Service
public class PersonService {
	
	
	private PersonDao dao;
	
	@Autowired
	public PersonService(PersonDao dao) {
		this.dao = dao;
	}
	
	public void savePerson(Person person) {
		
		if (person != null) {
			dao.savePerson(person);
		}
	}
	
	public Person findPerson(int id) {
		Person obj = dao.findPerson(id) ;
		
		if (obj != null) {
			return obj ;
		}
		return null ;
	}
	
	public boolean deletPerson(int id) {
		
		Person person = findPerson(id) ;
		
		if (person != null) {
			
			return dao.deletePerson(id) ;
		}
		return false ;
	}
	
	public void updatePerson(Person person) {
		
		int id = person.getId() ;
		
		Person person2 = findPerson(id) ;
		
		if (person2 != null && person != null) {
			
			dao.updatePerson(person);
		}
	}
	
	public List<Person> displayAll(){
		return dao.displayAll() ;
	}
}
