package org.example;

public class User {

    private int employee_id;
    private String name;
    private String email;
    private String department;
    private int salary;

    // Constructor
    public User(int employee_id, String name, String email,
                String department, int salary) {

        this.employee_id = employee_id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public int getemployee_id() {
        return employee_id;
    }

    public String getname() {
        return name;
    }

    public String getemail() {
        return email;
    }

    public String getdepartment() {
        return department;
    }

    public int getsalary() {
        return salary;
    }
}
