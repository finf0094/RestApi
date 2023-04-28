package com.example.springBootRest.controllers;

import com.example.springBootRest.entity.Student;
import com.example.springBootRest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/show")
    public List<Student> getStudents() {
        List<Student> students = studentService.getAllStudent();

        return students;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        Student student = studentService.getStudent(id);
        return student;
    }

    @PostMapping("/")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }


    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);

        return "Student for: " + id + " to deleted";
    }

}
