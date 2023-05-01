package com.example.springBootRest.controllers;

import com.example.springBootRest.entity.Student;
import com.example.springBootRest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
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

    @GetMapping("/show/{name}")
    public List<Student> getStudentsByName(@PathVariable("name") String name) {
        List<Student> allName = studentService.findAllByName(name);
        return allName;
    }
    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Student student) {
        student.setId(id);
        studentService.updateStudent(student);
    }
    @GetMapping("")
    public List<Student> searchStudentsByName(@RequestParam(name = "filter", required = false) String searchText) {
        return studentService.findByNameContainingIgnoreCase(searchText);
    }

}
