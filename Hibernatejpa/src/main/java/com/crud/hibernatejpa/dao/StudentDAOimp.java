package com.crud.hibernatejpa.dao;

import com.crud.hibernatejpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository //it support compnent scanning and translates jdbc exceptions

public class StudentDAOimp implements StudentDAO{

    //Step 1 : define entity manager field
    //step 2 : constructor for entity manager
    //step 3: Implement save method that arrived from interface


    //step1:
    private EntityManager entityManager;

    //step2:
    @Autowired
    public StudentDAOimp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //STep3:
    @Transactional  //we are performing an update
    @Override
    public void save(Student theStudent) {

        entityManager.persist(theStudent);
    }







    //Retrieveing
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }





    //Print All Students
    @Override
    public List<Student> findAll() {

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName asc",Student.class);
        return theQuery.getResultList();
    }



    @Override
    public List<Student> findByLastName(String lastName) {

        //Step 1: Create Query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName =: theData",Student.class);

        //Step 2: Set Parameters
        theQuery.setParameter("theData",lastName);

        //Step 3: Return results
        return theQuery.getResultList();
    }





    //Update Method
    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }


    //Delete
    @Override
    @Transactional
    public void Delete(Integer id) {

        // retrieve the student
        Student thestudent = entityManager.find(Student.class,id);

        //delete the student
        entityManager.remove(thestudent);
    }

    @Override
    @Transactional
    public int DeleteAll() {

        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
       return numRowsDeleted;
    }
}
