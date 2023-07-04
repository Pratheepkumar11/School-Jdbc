package org.example.controller;


import org.example.model.Student;
import org.example.repo.StudentRepoImpl;
import org.example.service.StudentService;
import org.example.service.StudentServiceImpl;

import java.sql.SQLException;

public class StudentController {
    public static void main(String[] args) throws SQLException {

        StudentService s = new StudentServiceImpl();
        Student newStudent = new Student(0,"prathe","11/08/2000");
        Student updateStudent = new Student(1,"prathees","11/08/2000");
        System.out.println(s.addStudent(newStudent));
        System.out.println(s.updateStudentDetails(updateStudent));
        System.out.println(s.getStudentDetails(2));
        System.out.println(s.deleteStudentDetails(4));
        s.allStudents();


    }



}
