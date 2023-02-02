package org.example.StrumienieWJanuszexie;

import java.util.ArrayList;
import java.util.List;

public class Sandbox {
    public static void main(String[] args) throws EmpolyeeNotFoundException {

        List<Employee> employees = new ArrayList<>();

        Employee first = new Employee("Krz", "Gad", "16.11.1995", 11.15, "Projektowy");
        Employee first1 = new Employee("Rob", "Rad", "16.11.1994", 10.15, "Projektowy");
        Employee first2 = new Employee("Mike", "Lad", "16.02.1990", 13.15, "Projektowy");
        Employee first3 = new Employee("Sok", "Kad", "20.01.1985", 12.5, "Projektowy");

        employees.add(first);
        employees.add(first1);
        employees.add(first2);
        employees.add(first3);
        /*
        for (int i = 0; i < employees.size(); i++) {
            System.out.println("Pracownik" + employees.get(i).getName() + employees.get(i).getSurname());
        }

         */
        EmployeesMockDAO dao = new EmployeesMockDAO();

        dao.create(new Employee("Krz", "Gad", "16.11.1995", 11.15, "Projektowy"));
        dao.create(new Employee("Rob", "Rad", "16.11.1994", 10.15, "Projektowy"));
        dao.create(new Employee("Mike", "Lad", "16.02.1990", 13.15, "Projektowy"));
        dao.create(new Employee("Sor", "Kad", "20.01.1985", 12.5, "Projektowy"));
        dao.create(first3);

       // dao.read("Rob", "Rad").ifPresent(empl -> System.out.println("Pracownik: " + empl.showAllData()));
            try {
                System.out.println("Sprawdzenie odczytu wynagrodzenia : " + dao.readSalary("R", "Rad"));
            } catch (EmpolyeeNotFoundException exception){
                System.out.println("Podałęś złego pracownika");
            }
        Employee first5 = new Employee("Mike", "Lad", "16.02.1990", 15.15, "Projektowy");

        System.out.println(dao.update("Mike", "Lad", first5));

        dao.read("Mike", "Lad").ifPresent(empl -> System.out.println("Pracownik: " + empl.showAllData()));

        List<Employee> newEmployeeList= dao.readAll();
        System.out.println("ilość elementów "+ newEmployeeList.size());

        // System.out.println(dao.delete("Sor", "Kad"));
        //newEmployeeList= dao.readAll();
        //System.out.println("ilość elementów "+ newEmployeeList.size());


        dao.read("Sor", "Kad").ifPresent(emplo -> dao.deleteByObject(emplo));
        newEmployeeList= dao.readAll();
        System.out.println("ilość elementów "+ newEmployeeList.size());
        System.out.println("_______");

        System.out.println(dao.read("Sor", "Kad"));


        System.out.println(dao.deleteByObject(first3));
        newEmployeeList= dao.readAll();
        System.out.println("ilość elementów "+ newEmployeeList.size());
        //System.out.println(dao.delete(toDelete));

        //System.out.println("ilość elementów "+ newEmployeeList.size());






    }
}
