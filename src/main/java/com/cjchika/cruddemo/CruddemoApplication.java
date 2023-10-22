package com.cjchika.cruddemo;

import com.cjchika.cruddemo.dao.StudentDAO;
import com.cjchika.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return  runner -> {
		//	createStudent(studentDAO);
		//	createMultipleStudents(studentDAO);
		//	readStudent(studentDAO);
		//	queryForStudents(studentDAO);
			queryForStudentsByLastName(studentDAO);
		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// GET A LIST OF STUDENTS
		List<Student> theStudents = studentDAO.getStudentByFirstName("Young");

		// DISPLAY LIST OF STUDENTS
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// GET A LIST OF STUDENTS
		List<Student> theStudents = studentDAO.getAllStudents();

		// DISPLAY LIST OF STUDENTS
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// CREATE A STUDENT OBJECT
		System.out.println("Creating new Student object...");
		Student tempStudent = new Student("JJ", "Doe", "jd@cjchika.com");

		// SAVE THE STUDENT
		System.out.println("Saving the new student object...");
		studentDAO.save(tempStudent);

		// DISPLAY ID OF THE SAVED STUDENT
		int theId = tempStudent.getId();
		System.out.println("Student  Generated ID: " + theId);

		// RETRIEVE STUDENT BASED ON THE ID-PRIMARY KEY
		System.out.println("Retrieving Student with ID: " + theId);
		Student theStudent = studentDAO.findById(theId);

		// DISPLAY STUDENT
		System.out.println("Displaying the student: " + theStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// CREATE MULTIPLE STUDENTS
		System.out.println("Creating new Student object...");
		Student tempStudent1 = new Student("John", "Doe", "jd@cjchika.com");
		Student tempStudent2 = new Student("Peter", "Doe", "pd@cjchika.com");
		Student tempStudent3 = new Student("Phillips", "Doe", "phd@cjchika.com");

		// SAVE THE STUDENT OBJECTS
		System.out.println("Saving the new student object...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// CREATE THE STUDENT OBJECT
		System.out.println("Creating new Student object...");
		Student tempStudent = new Student("CJ", "Chika", "man@cjchika.com");

		// SAVE THE STUDENT OBJECT
		System.out.println("Saving the new student object...");
		studentDAO.save(tempStudent);

		// DISPLAY ID OF THE SAVED STUDENT
		System.out.println("Saved student. Generated ID: " + tempStudent.getId());;
	}
}
