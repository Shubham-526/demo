package com.example.rest.example;

import com.example.rest.data.StudentData;
import com.example.rest.vo.Student;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatchExample {


@PutMapping ("/changeMarks/{id}")
    public String addStudent(@RequestBody Student student, @PathVariable int id){

    StudentData sd = new StudentData();
    String before = sd.ls.get(id-1).toString();

    sd.ls.get(id-1).setMarks(student.getMarks());


    String after = sd.ls.get(id-1).toString();

return "Before:" +before + "\n\n After" + after;



}



}
