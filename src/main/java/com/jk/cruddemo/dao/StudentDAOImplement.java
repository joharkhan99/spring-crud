package com.jk.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jk.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;

//Repository a specialization of @Component annotation 
//which is used to indicate that the class 
//provides the mechanism for storage, retrieval, 
//update, delete and search operation on objects.
@Repository
public class StudentDAOImplement implements StudentDAO {

	// define field for entity manager
	
	//	EntityManager manages the interaction between Java objects and the database.
	private EntityManager entityManager;
	
	// inject entity manager using constructr injection
	@Autowired
	public StudentDAOImplement(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	// implement save method	
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}


	
}
