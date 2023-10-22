package com.cjchika.cruddemo.dao;

import com.cjchika.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // DEFINE FILED FOR ENTITY MANAGER
    private EntityManager entityManager;

    // INJECT ENTITY MANAGER USING CONSTRUCTOR INJECTION
    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    // IMPLEMENT THE SAVE METHOD
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    // IMPLEMENT FIND BY ID METHOD
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    // IMPLEMENT GET ALL STUDENTS METHOD
    @Override
    public List<Student> getAllStudents() {
        // CREATE QUERY
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        // RETURN QUERY RESULTS
        return theQuery.getResultList();
    }

    // IMPLEMENT GET STUDENT BY PARAM-FIRSTNAME METHOD
    @Override
    public List<Student> getStudentByFirstName(String theFirstName) {
        // CREATE QUERY
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE firstName=:theData", Student.class);

        // SET QUERY PARAMETERS
        theQuery.setParameter("theData", theFirstName);

        // RETURN QUERY RESULTS
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class, id);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
