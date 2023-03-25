package com.example.rest.service;

import com.example.rest.dao.StudentDao;
import com.example.rest.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentDao dao;

    public List<Student> getAllStudent() {
        List <Student> studentlist = null;

        try {
         return dao.getAllStudent();
    }
       catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public Student getStudentById(Integer id) {
        try {
            return dao.getStudentById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateBranch(Integer id, Student s)  {
        try {
            dao.updateBranch(id,s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertStudent(Student s)  {
        try {
            dao.insertData(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
