package com.jk.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jk.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

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

	// read student from db using primary id key
	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}

	// get all students using query
	@Override
	public List<Student> findAllStudents() {
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student WHERE lastName=:theData",Student.class);
		theQuery.setParameter("theData", lastName);
		
		return theQuery.getResultList();
	}

	// updating a student record in DB
	@Override
	@Transactional
	public void updateStudent(Student thStudent) {
		entityManager.merge(thStudent);
	}

	@Override
	@Transactional
	public void updateAllStudents() {
		int numRowsUpdated = entityManager.createQuery("UPDATE Student SET lastName='Dough'").executeUpdate();
		System.out.println("Total Rows updated: "+numRowsUpdated);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		Student theStudent = entityManager.find(Student.class, id);
		entityManager.remove(theStudent);
	}

	@Override
	public void deleteMultipleStudents() {
		entityManager.createQuery("DELETE FROM Student WHERE lastName LIKE '%Dou%'").executeUpdate();
	}
	
}
