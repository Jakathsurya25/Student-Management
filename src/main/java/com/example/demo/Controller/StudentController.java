package com.example.demo.Controller;

import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class StudentController {

    @Autowired
    StudentService s;


    // GET ALL STUDENTS
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudent() {

        return ResponseEntity.ok(s.getAllStudents());
    }


    // GET STUDENT BY ROLL NUMBER
    @GetMapping("/students/{rno}")
    public ResponseEntity<Student> getStudentByRollNo(
            @PathVariable int rno) {

        return ResponseEntity.ok(
                s.getStudentByRollNo(rno)
        );
    }


    // ADD STUDENT
    @PostMapping("/students")
    public ResponseEntity<String> addStudent(
            @Valid @RequestBody Student std) {

        String result = s.addStudent(std);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(result);
    }


    // UPDATE STUDENT
    @PutMapping("/students")
    public ResponseEntity<String> updateStudent(
            @Valid @RequestBody Student std) {

        String result = s.updateStudent(std);

        return ResponseEntity.ok(result);
    }


    // DELETE STUDENT
    @DeleteMapping("/students/{rno}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable int rno) {

        String result = s.deleteStudent(rno);

        return ResponseEntity.ok(result);
    }


    // DELETE ALL STUDENTS
    @DeleteMapping("/students/clear")
    public ResponseEntity<String> deleteAllStudents() {

        return ResponseEntity.ok(
                s.deleteAllStudents()
        );
    }


    // SEARCH BY TECHNOLOGY
    @GetMapping("/students/technology/{tech}")
    public ResponseEntity<List<Student>> getAllStudentByTech(
            @PathVariable String tech) {

        return ResponseEntity.ok(
                s.getAllStudentByTechnology(tech)
        );
    }
}