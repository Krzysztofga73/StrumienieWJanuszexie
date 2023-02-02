package org.example.StrumienieWJanuszexie;

public class Employee {
    private final String name;
    private final String surname;
    private final String dateOfBirth;
    private Double salary;
    private String department;

    public Employee (String name, String surname, String dateOfBirth, double salary, String department){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        this.department = department;
    }

    public Employee (Employee originalEmployee){
        this.name = originalEmployee.name;
        this.surname = originalEmployee.surname;
        this.dateOfBirth = originalEmployee.dateOfBirth;
        this.salary = originalEmployee.salary;
        this.department = originalEmployee.department;
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

    public Double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String showAllData(){
        String text = this.name + ", " + this.surname + ", " + this.dateOfBirth + ", " + this.salary + ", " + this.department;
        return text;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
