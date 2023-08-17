package com.jk.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jk.cruddemo.dao.StudentDAO;
import com.jk.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student obj
		System.out.println("Creating new Student Object");
		Student tempStudent = new Student("John","Doe", "jd@yahoo.com");
		
		// save the student obj
		System.out.println("Saving to DBase");
		studentDAO.save(tempStudent);
		
		// display id of saved student
		System.out.println("Saved Student ID:"+ tempStudent.getId());
	}

}
