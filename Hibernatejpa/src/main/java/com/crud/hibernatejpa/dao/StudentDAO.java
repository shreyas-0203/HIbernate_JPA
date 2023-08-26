package com.crud.hibernatejpa.dao;

import com.crud.hibernatejpa.entity.Student;

import java.util.List;

public interface StudentDAO {

     //Create
     void save(Student theStudent);

     //Read
     Student findById(Integer id);

     //Print All stud
     List<Student> findAll();
     List<Student> findByLastName(String LastName);

     //Update
     void update(Student theStudent);

     //Delete
     void Delete(Integer id);

     int DeleteAll();
}
