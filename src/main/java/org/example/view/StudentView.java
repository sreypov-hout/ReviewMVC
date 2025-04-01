package org.example.view;

import org.example.control.StudentController;
import java.util.Scanner;

public class StudentView {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        StudentController controller = new StudentController();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> controller.addStudent(scanner);
                case 2 -> controller.viewStudents();
                case 3 -> controller.updateStudent(scanner);
                case 4 -> controller.deleteStudent(scanner);
                case 5 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
