package by.academy.it.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import by.academy.it.rest.entity.Person;
import by.academy.it.rest.services.IPersonService;

@RestController
@RequestMapping("/persons")
public class PersonRestController {
    @Autowired
    private IPersonService personService;

    @GetMapping(value = "")
    public ResponseEntity<List<Person>> getPersons() {
        List<Person> products = personService.getPersons();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public List<Person> getAll() {
        return personService.getPersons();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id) {
        Person person = personService.get(id);
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        Person newPerson = personService.create(person);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Person> updatePersons(
            @PathVariable("id") Long id,
            @RequestBody Person newPerson) {
        Person person = personService.get(id);
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        person.setName(newPerson.getName());
        person.setSurname(newPerson.getSurname());
        person.setAge(newPerson.getAge());
        newPerson = personService.update(person);
        return new ResponseEntity<>(newPerson, HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Person> updatePersonsAge(
            @PathVariable("id") Long id,
            @RequestBody Integer age) {
        Person person = personService.get(id);
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        person.setAge(age);
        person = personService.update(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deletePerson(@PathVariable("id") Long id) {
        personService.delete(id);
        return "OK";
    }
}
