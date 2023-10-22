package com.cjchika.cruddemo.dao;

import com.cjchika.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> getAllStudents();

    List<Student> getStudentByFirstName(String theFirstName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
