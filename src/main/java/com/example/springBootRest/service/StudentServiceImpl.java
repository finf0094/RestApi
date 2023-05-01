package com.example.springBootRest.service;

import com.example.springBootRest.dao.StudentRepository;
import com.example.springBootRest.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll(Sort.by("id"));
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getStudent(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Student> findAllByName(String name) {
        return studentRepository.findAllByName(name);
    }

    @Override
    public Student updateStudent(Student student) {
       return studentRepository.save(student);
    }

    @Override
    public List<Student> findByNameContainingIgnoreCase(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }
}
