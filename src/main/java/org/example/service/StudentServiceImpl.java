package org.example.service;


import org.example.model.Student;
import org.example.repo.StudentRepo;
import org.example.repo.StudentRepoImpl;

public class StudentServiceImpl implements StudentService {

    StudentRepo studentrepo = new StudentRepoImpl() ;


    @Override
    public String allStudents() {
        return this.studentrepo.allStudents();
    }

    @Override
    public String addStudent(Student student) {

        return this.studentrepo.addStudent(student);
    }

    @Override
    public Student getStudentDetails(int id) {
        return this.studentrepo.getStudentDetails(id);
    }

    @Override
    public String updateStudentDetails(Student student) {
        return this.studentrepo.updateStudentDetails(student);
    }

    @Override
    public String deleteStudentDetails(int id) {
        return this.studentrepo.deleteStudentDetails(id);
    }
}
