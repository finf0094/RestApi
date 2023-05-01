package com.example.springBootRest.service;

import com.example.springBootRest.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudent();
    public void addStudent(Student student);
    public void deleteStudent(int id);
    public Student getStudent(int id);
    public List<Student> findAllByName(String name);
    public Student updateStudent(Student student);
    public List<Student> findByNameContainingIgnoreCase(String name);
}
