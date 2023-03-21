package com.example.rest.controller;

import com.example.rest.dao.StudentDao;
import com.example.rest.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class StudentController {
 @Autowired
 StudentDao dao;
    @PostMapping("/enterstudent")
    public void insertStudent(@RequestBody Student s) throws SQLException {
       System.out.println(s.getBirth());
        dao.insertData(s);
    }


    @GetMapping(value = "/students")
    public List<Student> getStudents() throws SQLException {
        return dao.getAllStudent();



    }

    @GetMapping(value="/students/{id}")
    public Student getStudent(@PathVariable Integer id){
        return dao.getStudentById(id);


    }
    @PatchMapping(value="/student/updatebranch/{id}")
    public void updateBranch(@PathVariable Integer id,@RequestBody Student s){
        dao.updateBranch(id,s);


    }


    //Get the list of the student

    //Get the details of the one student

    //add new student

    //update students info.
}

