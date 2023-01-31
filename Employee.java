package org.example.StrumienieWJanuszexie;

public class Employee {
    private final String name;
    private final String surname;
    private final String dateOfBirth;
    private double salary;
    private String department;

    public Employee (String name, String surname, String dateOfBirth, double salary, String department){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
