package org.example.StrumienieWJanuszexie;

import java.util.List;
import java.util.Optional;

public interface DataAccessObject <TData>{

    Boolean create(TData newObj);
    Optional<TData> read(String name, String surname);
    Double readSalary(String name, String surname) throws EmpolyeeNotFoundException;
    List<TData> readAll();
    Boolean update(String name, String surname, TData updatedObj);
    Boolean deleteByObject(TData objToDelete);
    Boolean delete(String name, String surname);

}
