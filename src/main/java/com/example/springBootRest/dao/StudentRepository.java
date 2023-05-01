package com.example.springBootRest.dao;

import com.example.springBootRest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer>{
    public List<Student> findAllByName(String name);
    public List<Student> findByNameContainingIgnoreCase(String name);
}
