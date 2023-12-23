package com.luv2code.cruddemo.dao;

import java.util.List;

import com.luv2code.cruddemo.entity.Student;

public interface StudentDAO {
    public void save(Student theStudent);
    Student findById(int id);
    List<Student> findALL();
    List<Student> findByLastName(String theLastNam);
    void update(Student theStudent);
}
