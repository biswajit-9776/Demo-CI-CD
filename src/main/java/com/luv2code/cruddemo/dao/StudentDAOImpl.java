package com.luv2code.cruddemo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.stereotype.Repository;

// import org.springframework.beans.factory.annotation.Autowired;

import com.luv2code.cruddemo.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{
    
    //define filed for entity manager
    private EntityManager entityManager;
    
    //
    // @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(int id){
        return entityManager.find(Student.class, id);    
    }
    @Override
    public List<Student> findALL() {
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student WHERE lastName = 'Spectar'", Student.class);
        return typedQuery.getResultList();
    }
    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> theTypedQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
        theTypedQuery.setParameter("theData", theLastName);
        return theTypedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent){
        entityManager.merge(theStudent);
    }
}
