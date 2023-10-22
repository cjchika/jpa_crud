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
			createMultipleStudents(studentDAO);
		//	readStudent(studentDAO);
		//	queryForStudents(studentDAO);
		//	queryForStudentsByLastName(studentDAO);
		//	updateStudent(studentDAO);
		//	deleteStudent(studentDAO);
		//	deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		// RETRIEVE STUDENT BY ID
		int studentId = 4;

		System.out.println("Deleting student ID " + studentId);
		Student theStudent = studentDAO.findById(studentId);
		studentDAO.delete(studentId);

		// DISPLAY THE DELETED STUDENT
		System.out.println("Deleted student is: " + theStudent);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// RETRIEVE STUDENT BASED ON THE ID: PRIMARY KEY
		int studentId = 7;
		System.out.println("Getting student with ID: " + studentId);
		Student theStudent = studentDAO.findById(studentId);

		// CHANGE FIRST NAME TO "SCOTT"
		System.out.println("Updating the student...");
		theStudent.setFirstName("Scott");

		// UPDATE THE STUDENT
		studentDAO.update(theStudent);

		// DISPLAY THE UPDATED STUDENT
		System.out.println("Updated student is: " + theStudent);
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
		Student tempStudent = new Student("Nas", "Boi", "nas@cjchika.com");

		// SAVE THE STUDENT OBJECT
		System.out.println("Saving the new student object...");
		studentDAO.save(tempStudent);

		// DISPLAY ID OF THE SAVED STUDENT
		System.out.println("Saved student. Generated ID: " + tempStudent.getId());;
	}
}
