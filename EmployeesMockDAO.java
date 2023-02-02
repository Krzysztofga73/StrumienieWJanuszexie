package org.example.StrumienieWJanuszexie;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

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

    //Którego pracownika trzeba zwolnić (podaj pracownika z najwyższym wynagrodzeniem)?
    public Optional<Employee> getEmployeeWithBiggestSalary() {
        return this.employeesDataBase.stream().max((empl1, empl2) -> empl1.getSalary().compareTo(empl2.getSalary()));
    }

    //W którym dziale należy przeprowadzić restrukturyzację (który dział ma najwyższą sumę wynagrodzeń wszystkich swoich pracowników)?
    public String getMostExpensiveDepartment() {
        List<String> departments = new ArrayList<>();
        String depart = "";
        for (Employee empl : employeesDataBase) {
            String department = empl.getDepartment();
            if (!departments.contains(department)) {
                departments.add(department);
            }
        }
        Double max = 0.0;
        if (departments.size() > 0) {
            for (String dep : departments) {
                double temp = this.employeesDataBase.stream().filter(employee -> employee.getDepartment().equals(dep)).mapToDouble(empl -> empl.getSalary()).sum();
                if (temp > max) {
                    max = temp;
                    depart = dep;
                }
            }
        } else {
            depart = "Brak elementów do sprawdzenia";
        }
        return depart;
    }
//Czy dostanę zawału (ilu pracowników zarabia powyżej danej kwoty)?

    public int countEmployeesWithSalaryBiggerThan(Double givenSalary) {
        return (int) this.employeesDataBase.stream().filter(employee -> employee.getSalary() > givenSalary).count();
    }

    //   Któremu pracownikowi będzie trzeba kupić opakowanie Sagi (podaj pracownika, którego urodziny są najbliżej dzisiejszej daty)?
    public Employee closestBirthdayDate() throws ParseException {
        return null;
    }
}






