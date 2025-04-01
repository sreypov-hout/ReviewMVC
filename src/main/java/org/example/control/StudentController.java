package org.example.control;

import org.example.model.*;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    private StudentDao studentDAO;

    public StudentController() {
        this.studentDAO = new StudentDaoImpl();
    }

    public void addStudent(Scanner scanner) {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        Student student = new Student(id, name, age, department);
        studentDAO.addStudent(student);
    }

    public void viewStudents() {
        List<Student> students = studentDAO.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\nID | Name | Age | Department");
        for (Student student : students) {
            System.out.printf("%d | %s | %d | %s\n", student.getId(), student.getName(), student.getAge(), student.getDepartment());
        }
    }

    public void updateStudent(Scanner scanner) {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter New Department: ");
        String department = scanner.nextLine();
        Student student = new Student(id, name, age, department);
        studentDAO.updateStudent(student);
    }

    public void deleteStudent(Scanner scanner) {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        studentDAO.deleteStudent(id);
    }
}
