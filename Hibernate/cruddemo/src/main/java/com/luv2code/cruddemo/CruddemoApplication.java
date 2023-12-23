package com.luv2code.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student; 

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){ //injecting the StudentDAO
		return runner -> {
			// System.out.println("Hello World");

			// createStudent(studentDAO);

			// readStudent(studentDAO);

			// queryForStudent(studentDAO);

			// queryForStudentByLastName(studentDAO);

			updateStudent(studentDAO);
		};
	}
	private void updateStudent(StudentDAO studentDAO) {
		//retrieve Student based on id
        int id = 1;
        System.out.println("Getting student with id: " + id);

        Student theStudent = studentDAO.findById(id);

        System.out.println("Updating student...");

        //change the first name to Scooby

        theStudent.setFirstName("Scooby");
        studentDAO.update(theStudent);

        //display updated student
        System.out.println("Updated student: "+ theStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student> theStudentsLast = studentDAO.findByLastName("Public");

		for(Student tempStudent: theStudentsLast){
			System.out.println("Student: " + tempStudent);
		}

	}

	private void queryForStudent(StudentDAO studentDAO) {
		//get List of all students
		List<Student> theStudents = studentDAO.findALL();
	
		//display list of students
		for(Student tempStudent: theStudents){
			System.out.println("Student: " + tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("Creating a student object...");
		Student theStudent1 = new Student("Patrick", "James", "patjames@gmail.com");

		//save the student
		System.out.println("Saving the student object...");
		studentDAO.save(theStudent1);

		//display the id of the student
		int theID = theStudent1.getId();
		System.out.println("Saved student. Generated ID: " + theID);

		//receive student based on the id: primary key
		System.out.println("Retrieving student with id: ");
		Student s = studentDAO.findById(theID);
		
		//display the student
		System.out.println("Found the student: " + s);

	}

	private void createStudent(StudentDAO studentDAO){
		//create the Student object
		System.out.println("Creating new Student object...");
		Student theStudent1 = new Student("Patrick", "James", "patjames@gmail.com");
		Student theStudent2 = new Student("Maria", "Public", "maria@gmail.com");
		Student theStudent3 = new Student("Harvey", "Spectar", "chris@gmail.com");
		//save the Student object
		System.out.println("Saving the Student object...");
		studentDAO.save(theStudent1);
		studentDAO.save(theStudent2);
		studentDAO.save(theStudent3);

		//displaying id of the saved student
		System.out.println("Saved student. Generated ID: " + theStudent1.getId());
	}
}
