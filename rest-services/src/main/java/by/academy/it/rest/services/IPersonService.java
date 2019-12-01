package by.academy.it.rest.services;

import by.academy.it.rest.entity.Person;

import java.util.List;

public interface IPersonService extends IService<Person> {

    List<Person> getPersons();
    List<Person> getPersons(String name);

    Person create(Person person);

    void delete(Person person);
}
