package org.example.repo;


import org.example.model.Student;

import java.sql.*;

public class StudentRepoImpl implements StudentRepo{

    String URL = "jdbc:mysql://mysql5047.site4now.net:3306/db_a9b8fc_school";
    String username = "a9b8fc_school";
    String password = "Schools@123";


    public String addStudent(Student students) {

        try (Connection con = DriverManager.getConnection(URL, username, password))
        {

            PreparedStatement statement = con.prepareStatement("INSERT INTO students VALUES (?,?, ?)");
            statement.setString(1, null);
            statement.setString(2, students.getName());
            statement.setString(3, students.getDob());
            statement.executeUpdate();
            return  "A new user was inserted successfully!";
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Student getStudentDetails(int id) {
        // TODO Auto-generated method stub
        Student updatedStudent = null;
        try (Connection con = DriverManager.getConnection(URL, username, password)){
            PreparedStatement statement = con.prepareStatement("SELECT * FROM students WHERE id=?");

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            updatedStudent = new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return updatedStudent;
    }

    @Override
    public String updateStudentDetails(Student student) {

        try (Connection con = DriverManager.getConnection(URL, username, password))
        {
            PreparedStatement statement = con.prepareStatement("UPDATE students SET name=?, dob=? WHERE id=?");
            statement.setString(1, student.getName());
            statement.setString(2, student.getDob());
            statement.setInt(3, student.getId());
            statement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return "Student Updated";
    }

    @Override
    public String deleteStudentDetails(int id) {
        try (Connection con = DriverManager.getConnection(URL, username, password))
        {
            PreparedStatement statement = con.prepareStatement("DELETE FROM students WHERE id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return "Student Deleted";
    }

    public String allStudents() {

        try (Connection con = DriverManager.getConnection(URL, username, password))
        {

            String sql = "select * from students";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
            while (result.next()){
                int id = result.getInt(1);
                String name = result.getString(2);
                String dob = result.getString(3);
                String output = "User #%d: %s - %s - %s";
                System.out.println(String.format(output, ++count, id, name, dob));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Student details";
    }

    
}
