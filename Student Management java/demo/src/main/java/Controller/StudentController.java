package com.example.demo.Controller;

import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService s;

    // GET all students
    @GetMapping("students")
    public List<Student> getAllStudent() {
        return s.getAllStudents();
    }

    // GET student by roll number
    @GetMapping("students/{rno}")
    public Student getStudentByRollNo(@PathVariable int rno) {
        return s.getStudentByRollNo(rno);
    }

    // POST - add a new student
    @PostMapping("students")
    public String addStudent(@RequestBody Student std) {
        return s.addStudent(std);
    }

    // PUT - update an existing student
    @PutMapping("students")
    public String updateStudent(@RequestBody Student std) {
        return s.updateStudent(std);
    }

    // DELETE - delete student by roll number
    @DeleteMapping("students/{rno}")
    public String deleteStudent(@PathVariable int rno) {
        return s.deleteStudent(rno);
    }
    // DELETE all students
    @DeleteMapping("students/clear")
    public String deleteAllStudents() {
        return s.deleteAllStudents();
    }

    @GetMapping("students/technology/{tech}")
    public List<Student> getAllStudentByTech(@PathVariable String tech){
        return s.getAllStudentByTechnology(tech);
    }
}