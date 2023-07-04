package org.example.repo;


import org.example.model.Student;

import java.sql.SQLException;

public interface StudentRepo {

    String allStudents();
    String addStudent(Student student);
    Student getStudentDetails(int id);
    String updateStudentDetails(Student student);
    String deleteStudentDetails(int id);

}
