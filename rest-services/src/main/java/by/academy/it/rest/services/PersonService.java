package by.academy.it.rest.services;

import by.academy.it.rest.dao.PersonDao;
import by.academy.it.rest.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PersonService extends BaseService<Person> implements IPersonService {
    @Autowired
    PersonDao personDao;

    @Override
    public List<Person> getPersons(String name) {
        return personDao.getPersons(name);
    }

    public List<Person> getPersons() {
        return personDao.getPersons();
    }

    public Person create(Person person) {
        if (person != null) {
            return personDao.add(person);
        }
        return person;
    }

    public void delete(Person person) {
        if (person != null) {
            personDao.delete(person.getId());
        }
    }
}
