package org.example.StrumienieWJanuszexie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeesMockDAO implements DataAccessObject<Employee> {
    private List<Employee> employeesDataBase;


    public EmployeesMockDAO() {
        this.employeesDataBase = new ArrayList<>();
    }

    @Override
    public Boolean create(Employee newEmployee) {
        if (this.employeesDataBase.contains(newEmployee)) {
            return false;
        } else {
            this.employeesDataBase.add(newEmployee);
            return true;
        }
    }

    @Override
    public Optional<Employee> read(String name, String surname) {
        for (int i = 0; i < employeesDataBase.size(); i++) {
            if (employeesDataBase.get(i).getName().equals(name) && employeesDataBase.get(i).getSurname().equals(surname)) {
                //System.out.println("Odczytany pracownik: " + employeesDataBase.get(i).getName() + " " + employeesDataBase.get(i).getSurname());
                return Optional.of(this.employeesDataBase.get(i));
            }
        }
        return Optional.empty();
    }

    @Override
    public Double readSalary(String name, String surname) throws EmpolyeeNotFoundException {
        Optional<Employee> emplo = Optional.empty();
        for (int i = 0; i < employeesDataBase.size(); i++) {
            if (employeesDataBase.get(i).getName().equals(name) && employeesDataBase.get(i).getSurname().equals(surname)) {
                emplo = Optional.of(employeesDataBase.get(i));
                return employeesDataBase.get(i).getSalary();
            }
        }
        if (emplo.isEmpty()) {
            throw new EmpolyeeNotFoundException("Employee not found!");
        }
        return 0.0;
    }


    @Override
    public List<Employee> readAll() {
        return new ArrayList<>(this.employeesDataBase);
    }

    @Override
    public Boolean update(String name, String surname, Employee updatedObj) {
        Optional<Employee> objToUpdate = Optional.empty();
        int index = 0;
        for (int i = 0; i < employeesDataBase.size(); i++) {
            if (employeesDataBase.get(i).getName().equals(name) && employeesDataBase.get(i).getSurname().equals(surname)) {
                index = this.employeesDataBase.indexOf(employeesDataBase.get(i));
                System.out.println(index);
                objToUpdate = Optional.of(employeesDataBase.get(i));
            }
        }
        if (this.employeesDataBase.contains(updatedObj)) {
            return false;
        } else if (objToUpdate.isEmpty()) {
            return false;
        } else {
            this.employeesDataBase.set(index, updatedObj);
            return true;
        }
    }

    @Override
    public Boolean deleteByObject(Employee objToDelete) {

        if (this.employeesDataBase.contains(objToDelete)) {
            this.employeesDataBase.remove(objToDelete);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean delete(String name, String surname) {
        Optional<Employee> objToDelete = Optional.empty();
        for (int i = 0; i < employeesDataBase.size(); i++) {
            if (employeesDataBase.get(i).getName().equals(name) && employeesDataBase.get(i).getSurname().equals(surname)) {
                objToDelete = Optional.of(employeesDataBase.get(i));
                this.employeesDataBase.remove(i);
                return true;
            }
        }
        if (objToDelete.isEmpty()) {
            return false;
        }
        return false;
    }
}
