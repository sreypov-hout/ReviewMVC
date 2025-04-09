package org.example.control;

import org.example.model.*;

import java.util.List;
import java.util.Scanner;

public class EmployeeController {
    private EmployeeDao employeeDAO;

    public EmployeeController() {
        this.employeeDAO = new EmployeeDaoImpl();
    }

    public void addEmployee(Scanner scanner) {
        String inputIdStr;
        do {
            System.out.print("Enter ID: ");
            inputIdStr = scanner.nextLine();
            if (!Validation.isValidId(inputIdStr)) {
                System.out.println("Invalid ID. Only numbers are allowed.");
            }
        } while (!Validation.isValidId(inputIdStr));
        int id = Integer.parseInt(inputIdStr);

        String name;
        do {
            System.out.print("Enter Name: ");
            name = scanner.nextLine();
            if (!Validation.isValidName(name)) {
                System.out.println("Invalid name. Use only letters and spaces");
            }
        } while (!Validation.isValidName(name));

        String gender;
        do {
            System.out.print("Enter Gender: ");
            gender = scanner.nextLine();
            if (!Validation.isValidGender(gender)) {
                System.out.println("Invalid gender. Only 'M' or 'F' allowed.");
            }
        } while (!Validation.isValidGender(gender));

        String inputAgeStr;
        do {
            System.out.print("Enter Age: ");
            inputAgeStr = scanner.nextLine();
            if (!Validation.isValidAge(inputAgeStr)) {
                System.out.println("Invalid age. Must be 18 to 90.");
            }
        } while (!Validation.isValidAge(inputAgeStr));
        int age = Integer.parseInt(inputAgeStr);

        String department;
        do {
            System.out.print("Enter Department: ");
            department = scanner.nextLine();
            if (!Validation.isValidDepartment(department)) {
                System.out.println("Invalid department. Only letters and spaces ");
            }
        } while (!Validation.isValidDepartment(department));

        String inputSalaryStr;
        do {
            System.out.print("Enter Salary: ");
            inputSalaryStr = scanner.nextLine();
            if (!Validation.isValidSalary(inputSalaryStr)) {
                System.out.println("Invalid salary. Salary must be a positive number.");
            }
        } while (!Validation.isValidSalary(inputSalaryStr));
        double salary = Double.parseDouble(inputSalaryStr);


        Employee employee = new Employee(id, name, gender, age, department, salary);
        employeeDAO.addEmployee(employee);
    }


    public void viewEmployees() {
        List<Employee> employees = employeeDAO.getAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("\nID | Name | Gender | Age | Department | Salary");
        for (Employee employee : employees) {
            System.out.printf("%d | %s | %s | %d | %s | %.2f\n", employee.getId(), employee.getName(), employee.getGender(), employee.getAge(), employee.getDepartment(), employee.getSalary());
        }
    }

    public void updateEmployee(Scanner scanner) {
        String inputIdStr;
        do{
            System.out.print("Enter Student ID to update: ");
            inputIdStr = scanner.nextLine();
            if (!Validation.isValidId(inputIdStr)) {
                System.out.println("Invalid ID. Only numbers are allowed.");
            }
        }while (!Validation.isValidId(inputIdStr));
        int id = Integer.parseInt(inputIdStr);

        String name;
        do{
            System.out.print("Enter New Name: ");
            name = scanner.nextLine();
            if (!Validation.isValidName(name)) {
                System.out.println("Invalid name. Only letters and spaces");
            }
        }while (!Validation.isValidName(name));

        String gender;
        do{
            System.out.print("Enter New Gender: ");
            gender = scanner.nextLine();
            if (!Validation.isValidGender(gender)) {
                System.out.println("Invalid gender. Only 'M' or 'F' allowed.");
            }
        }while (!Validation.isValidGender(gender));

        String inputAgeStr;
        do{
            System.out.print("Enter New Age: ");
            inputAgeStr = scanner.nextLine();
            if (!Validation.isValidAge(inputAgeStr)) {
                System.out.println("Invalid age. Must be 18 to 90.");
            }
        }while (!Validation.isValidAge(inputAgeStr));
        int age = Integer.parseInt(inputAgeStr);

        String department;
        do{
            System.out.print("Enter New Department: ");
            department = scanner.nextLine();
            if (!Validation.isValidDepartment(department)) {
                System.out.println("Invalid department. Only letters and spaces ");
            }
        }while (!Validation.isValidDepartment(department));

        String inputSalaryStr;
        do {
            System.out.print("Enter New Salary: ");
            inputSalaryStr = scanner.nextLine();
            if (!Validation.isValidSalary(inputSalaryStr)) {
                System.out.println("Invalid salary. Salary must be a positive number");
            }
        }while (!Validation.isValidSalary(inputSalaryStr));
        double salary = Double.parseDouble(inputSalaryStr);

        Employee employee = new Employee(id, name, gender, age, department, salary);
        employeeDAO.updateEmployee(employee);
    }

    public void deleteEmployee(Scanner scanner) {
        String inputIdStr;
        do{
            System.out.print("Enter Student ID to delete: ");
            inputIdStr = scanner.nextLine();
            if (!Validation.isValidId(inputIdStr)) {
                System.out.println("Invalid ID. Only numbers are allowed.");
            }
        }while (!Validation.isValidId(inputIdStr));
        int id = Integer.parseInt(inputIdStr);

        employeeDAO.deleteEmployee(id);
    }
}
