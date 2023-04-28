package com.example.springBootRest.dao;

import com.example.springBootRest.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> getAllStudent() {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Student> studentQuery = session.createQuery("from Student", Student.class);
//        List<Student> students = studentQuery.getResultList();

        Query query = entityManager.createQuery("from Student");
        return query.getResultList();
    }

    @Override
    public void addStudent(Student student) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(student);
        entityManager.merge(student);
    }

    @Override
    public void deleteStudent(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        session.createQuery("DELETE FROM Student e WHERE e.id = :id")
//                .setParameter("id", id)
//                .executeUpdate();
        entityManager.createQuery("DELETE FROM Student e WHERE e.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Student getStudent(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Student student = session.get(Student.class, id);

        return entityManager.find(Student.class, id);
    }

    @Override
    public void updateStudent(int id, Student student) {
        Query query = entityManager.createQuery("update Student set gpa =: gpa, name =: name, university =: university where id =: id");
        query.setParameter("gpa", student.getGpa());
        query.setParameter("name", student.getName());
        query.setParameter("university", student.getUniversity());
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
