package org.example.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void addEmployee(Employee employee) {
        try (Connection conn = Connect.getConnection()) {
            String query = "INSERT INTO employee_tb (id, name, gender, age, department, salary) VALUES (?, ?, ?, ?, ? , ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, employee.getId());
            stmt.setString(2, employee.getName());
            stmt.setString(3, employee.getGender());
            stmt.setInt(4, employee.getAge());
            stmt.setString(5, employee.getDepartment());
            stmt.setDouble(6, employee.getSalary());
            stmt.executeUpdate();
            System.out.println("Employee added successfully!");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection conn = Connect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employee_tb")) {
            while (rs.next()) {
                employees.add(new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("gender"), rs.getInt("age"), rs.getString("department"), rs.getInt("salary")));
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) {
        try (Connection conn = Connect.getConnection()) {
            String query = "UPDATE employee_tb SET name=?, gender=?, age=?, department=?, salary=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getGender());
            stmt.setInt(3, employee.getAge());
            stmt.setString(4, employee.getDepartment());
            stmt.setDouble(5, employee.getSalary());
            stmt.setInt(6, employee.getId());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee updated successfully!");
            } else {
                System.out.println("Employee not found!");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try (Connection conn = Connect.getConnection()) {
            String query = "DELETE FROM employee_tb WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Employee not found!");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
