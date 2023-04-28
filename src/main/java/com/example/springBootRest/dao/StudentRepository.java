package com.example.springBootRest.dao;

import com.example.springBootRest.entity.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> getAllStudent();
    public void addStudent(Student student);
    public void deleteStudent(int id);
    public Student getStudent(int id);
    public void updateStudent(int id, Student student);
}
