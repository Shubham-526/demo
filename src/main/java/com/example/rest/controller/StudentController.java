package com.example.rest.controller;
import com.example.rest.model.Student;
import com.example.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/enterstudent")
    public void insertStudent(@RequestBody Student s)  {
       System.out.println(s.getBirth());
        studentService.insertStudent(s);
    }


    @GetMapping(value = "/students")
    public List<Student> getStudents()  {
        return studentService.getAllStudent();



    }

    @GetMapping(value="/students/{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }



    @PatchMapping(value="/student/updatebranch/{id}")
    public void updateBranch(@PathVariable Integer id,@RequestBody Student s){
        studentService.updateBranch(id,s);
    }


    //Get the list of the student

    //Get the details of the one student

    //add new student

    //update students info.
}

