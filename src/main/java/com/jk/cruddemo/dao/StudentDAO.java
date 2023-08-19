package com.jk.cruddemo.dao;

import java.util.List;

import com.jk.cruddemo.entity.Student;

public interface StudentDAO {
	
	void save(Student theStudent);
	Student findById(Integer id);
	List<Student> findAllStudents();

}
