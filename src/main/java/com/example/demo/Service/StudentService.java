package com.example.demo.Service;

import com.example.demo.Exception.StudentNotFoundException;
import com.example.demo.Model.Student;
import com.example.demo.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo repo;


    // GET ALL STUDENTS
    public List<Student> getAllStudents() {

        return repo.findAll();
    }


    // GET STUDENT BY ROLL NUMBER
    public Student getStudentByRollNo(int rno) {

        return repo.findById(rno)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student with roll number "
                                        + rno
                                        + " not found"
                        )
                );
    }


    // ADD STUDENT
    public String addStudent(Student std) {

        repo.save(std);

        return "Student created successfully";
    }


    // UPDATE STUDENT
    public String updateStudent(Student std) {

        if (repo.existsById(std.getRno())) {

            repo.save(std);

            return "Student updated successfully";
        }

        throw new StudentNotFoundException(
                "Student with roll number "
                        + std.getRno()
                        + " not found"
        );
    }


    // DELETE STUDENT
    public String deleteStudent(int rno) {

        if (repo.existsById(rno)) {

            repo.deleteById(rno);

            return "Student deleted successfully";
        }

        throw new StudentNotFoundException(
                "Student with roll number "
                        + rno
                        + " not found"
        );
    }


    // DELETE ALL STUDENTS
    public String deleteAllStudents() {

        repo.deleteAll();

        return "All students deleted successfully";
    }


    // SEARCH BY TECHNOLOGY
    public List<Student> getAllStudentByTechnology(
            String tech) {

        return repo.findByTechnology(tech);
    }
}