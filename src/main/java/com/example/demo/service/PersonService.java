package com.example.demo.service;

import com.example.demo.enitity.Person;
import com.example.demo.exception.PersonNotFoundException;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() ->
                        new PersonNotFoundException("Couldn't find person with id " + id));
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Person person, Long id) {
        return personRepository.findById(id)
                .map(p -> {
                    p.setFirstName(person.getFirstName());
                    p.setLastName(person.getLastName());
                    p.setAge(person.getAge());
                    return personRepository.save(p);
                })
                .orElseThrow(() ->
                        new PersonNotFoundException("Couldn't find person with id " + id));
    }

    public String deletePerson(Long id) {
        personRepository.deleteById(id);
        return "Deleted person with id " + id;
    }
}
