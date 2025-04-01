package org.example.model;

import java.util.List;

public interface StudentDao {
    void addStudent(Student student);
    List<Student> getAllStudents();
    void updateStudent(Student student);
    void deleteStudent(int id);
}