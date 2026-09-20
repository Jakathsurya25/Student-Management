package com.example.demo.Controller;

import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentWebController {

    @Autowired
    StudentService s;


    // Display all students
    @GetMapping("/Students")
    public String getAllStudents(Model model) {

        model.addAttribute("students", s.getAllStudents());

        return "students";
    }


    // Show Add Student page
    @GetMapping("/Students/add")
    public String showAddStudentPage(Model model) {

        model.addAttribute("student", new Student());

        return "add-student";
    }


    // Add Student
    @PostMapping("/Students/add")
    public String addStudent(@ModelAttribute Student student) {

        s.addStudent(student);

        return "redirect:/Students";
    }


    // Show Edit Student page
    @GetMapping("/Students/edit/{rno}")
    public String showEditStudentPage(
            @PathVariable int rno,
            Model model) {

        Student student = s.getStudentByRollNo(rno);

        model.addAttribute("student", student);

        return "edit-student";
    }


    // Update Student
    @PostMapping("/Students/update")
    public String updateStudent(@ModelAttribute Student student) {

        s.updateStudent(student);

        return "redirect:/Students";
    }


    // Delete Student
    @GetMapping("/Students/delete/{rno}")
    public String deleteStudent(@PathVariable int rno) {

        s.deleteStudent(rno);

        return "redirect:/Students";
    }


    // Delete all students
    @GetMapping("/Students/delete-all")
    public String deleteAllStudents() {

        s.deleteAllStudents();

        return "redirect:/Students";
    }


    // Search student by roll number
    @GetMapping("/Students/search")
    public String searchStudent(
            @RequestParam int rno,
            Model model) {

        Student student = s.getStudentByRollNo(rno);

        model.addAttribute("students", java.util.List.of(student));

        return "students";
    }


    // Filter by technology
    @GetMapping("/Students/technology")
    public String searchByTechnology(
            @RequestParam String technology,
            Model model) {

        model.addAttribute(
                "students",
                s.getAllStudentByTechnology(technology)
        );

        return "students";
    }
}