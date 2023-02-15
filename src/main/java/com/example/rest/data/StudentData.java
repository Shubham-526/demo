package com.example.rest.data;

import com.example.rest.vo.Student;

import java.util.ArrayList;

import java.util.List;

public class StudentData {



   public List <Student> ls;


    public StudentData(){

ls = new ArrayList<>();
ls.add(new Student(1,"Shubham",78));
ls.add(new Student(2,"Naveen",89));
ls.add(new Student(3,"Khushi",87));
ls.add(new Student(4,"Dimple",67));






    }





}
