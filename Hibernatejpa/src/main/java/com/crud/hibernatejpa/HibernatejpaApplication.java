package com.crud.hibernatejpa;

import com.crud.hibernatejpa.dao.StudentDAO;
import com.crud.hibernatejpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class HibernatejpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatejpaApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO dao) {
		return runner ->
		{
			createStudent(dao);

			//retrieveStud(dao);

			//queryForStudents(dao);

			//queryforLastName(dao);

			//updatestud(dao);

			//DeleteStud(dao);

			//DelteAllStud(dao);
		};
	}

	private void DelteAllStud(StudentDAO dao) {

		System.out.println("Deleting Alll eles");
		int cnt = dao.DeleteAll();
		System.out.println("Count of all deleted: " + cnt);
	}


	private void DeleteStud(StudentDAO dao) {

		int studentid = 2;
		System.out.println("Deleting id: "+ studentid);
		dao.Delete(studentid);
	}


	private void updatestud(StudentDAO dao) {

		//Step 1 : retrieve stud based on primary key
		//Step 2: change first name
		//step 3: display updated stud

		//step 1:
		int studid = 2;
		System.out.println("Getting stud id as : "+ studid);
		Student mystud = dao.findById(studid);

		//step 2:
		System.out.println("Updating Details");
		mystud.setEmail("bhosaleshreyas53@gmail.com");
		dao.update(mystud);

		//step 3:
		System.out.println("Updated Details : "+ mystud);

	}


	private void queryforLastName(StudentDAO dao) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter Last Name to Search..");
		String inputt = input.nextLine();

		//Step 1:
		List<Student> thestudd = dao.findByLastName(inputt);

		//Step 2:
		for (Student temp : thestudd) {

			System.out.println(temp);

		}

	}


	private void queryForStudents(StudentDAO dao) {
		//Step 1: Get List of all students
		//step 2:  Display List of Students;

		//Step1:
		List<Student> thestud = dao.findAll();

		//step2:
		for (Student temp : thestud) {

			System.out.println(temp);
		}
	}

	private void retrieveStud(StudentDAO dao) {

		//step 1 : create stud obj
		//step 2: save stud obj
		//step 3: print stud
		//step 4: retrieve stud by id : primary key
		//step 5: print the obj

		//step 1:
		System.out.println("Creating an Object..");
		Student tempvar = new Student("SannketAppa","Narsale","sanket.narsale@mitaoe.ac.in");

		//step2:
		System.out.println("Saving an Object");
		dao.save(tempvar);

		//step3:
		int theid = tempvar.getId();
		System.out.println("Saved Object ID "+ theid);

		//step 4:
		System.out.println("Retrieving an object by primary key");
		Student mystud = dao.findById(theid);

		//step 5:
		System.out.println("Object : "+ mystud);
	}


	private void createStudent(StudentDAO daoo) {

		//step 1: create the student object
		//step 2: save the student object
		//step 3:  display id of saved student


		//step1:
		System.out.println("Creating New Object....");
		Student tempstud = new Student("Shreyas","Bhosale","shreyas.bhosale@mitaoe.ac.in");
		Student newstud = new Student("Aditya","Waghmare","adi@gmail.com");
		Student temp1 = new Student("Akshay","Jadhav","apj@gmail.com");

		//step2:
		System.out.println("Saving obj");
		daoo.save(temp1);

		//step 3:
		System.out.println("Id : "+ temp1.getId());
	}
}
