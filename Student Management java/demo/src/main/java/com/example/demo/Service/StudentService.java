package com.example.demo.Service;

import com.example.demo.Model.Student;
import com.example.demo.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo repo;

    // Get all students
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // Get student by roll number
    public Student getStudentByRollNo(int rno) {
        return repo.findById(rno).orElse(null);
    }

    // Add student
    public String addStudent(Student std) {
        repo.save(std);
        return "saved";
    }

    // Update student
    public String updateStudent(Student std) {
        if (repo.existsById(std.getRno())) {
            repo.save(std);
            return "updated";
        }
        return "Student not found";
    }

    // Delete student
    public String deleteStudent(int rno) {
        if (repo.existsById(rno)) {
            repo.deleteById(rno);
            return "deleted";
        }
        return "Student not found";
    }

    public String deleteAllStudents() {
        repo.deleteAll();
        return "All students deleted";
    }


    public List<Student> getAllStudentByTechnology(String tech) {
        return repo.findByTechnology(tech);

    }
}