package com.example.rest.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class Student {

    @Override
    public String toString() {
        //this has to be changed!
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", branch=" + branch +
                '}';
    }

  public Student(int id , String name , String branch,Date birth){
       this.id = id;
       this.name = name;
    this.branch= branch;
    this.birth=birth;
   }

    private int id;
    private String name;

    private String branch;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date birth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        System.out.println("x");
        this.branch = branch;
    }

    public Date getBirth(){return birth;}

    public void setBirth(Date birth){

        this.birth=birth;

    }


}
