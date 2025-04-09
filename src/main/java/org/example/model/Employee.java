package org.example.model;

public class Employee {
    private int id;
    private String name;
    private String gender;
    private int age;
    private String department;
    private double salary;

    public Employee(int id, String name, String gender, int age, String department, double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}
