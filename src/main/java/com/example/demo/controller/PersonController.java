package com.example.demo.controller;

import com.example.demo.enitity.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/person")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/person/{id}")
    public Person findById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/person")
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/person/{id}")
    public Person updatePerson(@RequestBody Person person, @PathVariable Long id) {
        return personService.updatePerson(person, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/person/{id}")
    public String deletePerson(@PathVariable Long id) {
        return personService.deletePerson(id);
    }

}
