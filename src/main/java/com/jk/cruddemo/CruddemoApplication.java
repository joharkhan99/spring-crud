package com.jk.cruddemo;

import java.util.List;

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
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
			
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
			getStudentsByLastName(studentDAO);
		};
	}
	

	private void getStudentsByLastName(StudentDAO studentDAO) {
		List<Student> stuList = studentDAO.findByLastName("Khan");
		for(Student s: stuList) {
			System.out.println(s.toString());
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAllStudents();
		for(Student s: students) {
			System.out.println(s.toString());
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating student object...");
		Student s = new Student("Johar", "Khan", "jk@gmail.com");
		
		System.out.println("Saving student to DB...");
		studentDAO.save(s);
		
		System.out.println("Reading student with "+ s.getId()+" id");
		Student findStud = studentDAO.findById(s.getId());
		System.out.println(findStud.toString());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		
		System.out.println("Creating Four Student Objs");
		Student s1 = new Student("stud1", "last1", "sl1@gmail.com");
		Student s2 = new Student("stud2", "last2", "sl2@gmail.com");
		Student s3 = new Student("stud3", "last3", "sl3@gmail.com");
		Student s4 = new Student("stud4", "last4", "sl4@gmail.com");
		
		System.out.println("Saving to DB");
		studentDAO.save(s1);
		studentDAO.save(s2);
		studentDAO.save(s3);
		studentDAO.save(s4);
		
		System.out.println("Saved Four Students");
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
