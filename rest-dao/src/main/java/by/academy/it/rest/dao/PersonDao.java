package by.academy.it.rest.dao;

import java.util.List;

import by.academy.it.rest.entity.Person;

/**
 * Created by yslabko on 024 24 мар 2015.
 */
public interface PersonDao extends Dao<Person> {
    List<Person> getPersons();
    List<Person> getPersons(String name);
}
