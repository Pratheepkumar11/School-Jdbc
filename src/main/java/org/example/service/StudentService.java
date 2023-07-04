package org.example.service;


import org.example.model.Student;


public interface StudentService {

    String allStudents();
    String addStudent(Student student );
    Student getStudentDetails(int id);
    String updateStudentDetails(Student student);
    String deleteStudentDetails(int id);

}
