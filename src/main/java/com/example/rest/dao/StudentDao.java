package com.example.rest.dao;

import com.example.rest.vo.Student;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    private DataSource dataSource;

public void insertData(Student s) throws SQLException {
    try(Connection connection = dataSource.getConnection()){


        Integer id = s.getId();
        String nam= s.getName();
        String branch = s.getBranch();
        Date birthDate=s.getBirth();

        Statement st = connection.createStatement();
        st.executeUpdate("INSERT INTO student VALUES ("+id+",'"+nam+"','"+branch+"','"+birthDate+"')");



    }

    catch (Exception e){

        System.out.println(e);
    }



}


public List<Student> getAllStudent() throws SQLException {

    List<Student> studentData = new ArrayList<>();

    String sql = "SELECT * FROM student";
    try (Connection connection = dataSource.getConnection()) {
        Statement st = connection.createStatement();
       ResultSet rs = st.executeQuery(sql);
       while(rs.next()){
           studentData.add(new Student(rs.getInt("id"),rs.getString("name"),rs.getString("branch"),rs.getDate("birth")));



       }



    }
    catch (Exception e){
        System.out.println(e);

    }
   return studentData;

}

public Student getStudentById(Integer id){
    String sql = "SELECT * FROM STUDENT WHERE id ="+id;
    try {
        Connection connection = dataSource.getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
            return (new Student(rs.getInt("id"),rs.getString("name"),rs.getString("branch"),rs.getDate("birth")));

        }
        else{
        throw new SQLException("This student does not exist");}


    } catch (SQLException e) {
        throw new RuntimeException(e);
    }


}


public void updateBranch(Integer id,Student s){
    String branch = s.getBranch();
    String sql = "UPDATE student SET branch='"+branch+"' WHERE id="+id;
    try {
        Connection connection = dataSource.getConnection();
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }


}


}
