package org.example.model;

public class Validation {
    public static boolean isValidId(String id) {
        return id.matches("\\d+"); // Only digits allowed
    }

    public static boolean isValidName(String name) {
        return name.matches("^[a-zA-Z\\s]{1,50}$"); // Only letters & spaces, max 50 characters
    }

    public static boolean isValidAge(String age) {
        return age.matches("^(1[89]|[2-8][0-9]|90)$");
    }

    public static boolean isValidGender(String gender) {
        return gender != null && gender.matches("^[MF]$");
    }

    public static boolean isValidDepartment(String department) {
        return department.matches("^[a-zA-Z\\s]{1,50}$"); // Only letters & spaces, max 50 characters
    }

    public static boolean isValidSalary(String salary) {
        return salary.matches("^\\d+(\\.\\d{1,2})?$"); // matches positive numbers with up to 2 decimal places
    }
}
