package org.example.StrumienieWJanuszexie;

import java.util.List;
import java.util.Optional;

public interface DataAccessObject <T>{


    Boolean create(T newObj);
    Optional<T> read(String name, String surname);
    List<T> readAll();
    Boolean update(T updatedObj);
    Boolean delete(T updatedObj);



}
