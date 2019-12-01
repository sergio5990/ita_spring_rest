package by.academy.it.rest.dao.impl;

import by.academy.it.rest.dao.PersonDao;
import by.academy.it.rest.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public class PersonDaoImpl extends BaseDao<Person> implements PersonDao {

    public PersonDaoImpl(){
        super();
        clazz = Person.class;
    }

    @Override
    public List<Person> getPersons() {
        return getEm().createQuery("from Person").getResultList();
    }

    @Override
    public List<Person> getPersons(String name) {
        return getEm().createQuery("from Person where name=:name")
                .setParameter("name", name)
                .getResultList();
    }
}
