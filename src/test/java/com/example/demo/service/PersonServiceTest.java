package com.example.demo.service;

import com.example.demo.enitity.Person;
import com.example.demo.exception.PersonNotFoundException;
import com.example.demo.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.util.ObjectUtils.isEmpty;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonService personService;

    @Test
    void findAll() {
        when(personRepository.findAll())
                .thenReturn(Collections.singletonList(new Person()));
        List<Person> personList = personService.findAll();
        assertFalse(isEmpty(personList));
    }

    @Test
    void findById() {
        when(personRepository.findById(any(Long.class)))
                .thenReturn(Optional.of(new Person()));
        Person person = personService.findById(1L);
        assertNotNull(person);
    }

    @Test
    void findByIdShouldThrowPersonNotFoundException() {
        when(personRepository.findById(any(Long.class)))
                .thenReturn(Optional.empty());
        Exception e = assertThrows(PersonNotFoundException.class,
                () -> personService.findById(1L));
        assertEquals("Couldn't find person with id 1", e.getMessage());
    }

    @Test
    void createPerson() {
        when(personRepository.save(any(Person.class)))
                .thenReturn(new Person());
        Person person = personService.createPerson(new Person());
        assertNotNull(person);
    }

    @Test
    void updatePerson() {
        when(personRepository.save(any(Person.class)))
                .thenReturn(new Person());
        when(personRepository.findById(any(Long.class)))
                .thenReturn(Optional.of(new Person()));
        Person person = personService.updatePerson(new Person(), 1L);
        assertNotNull(person);
    }

    @Test
    void deletePerson() {
        String message = personService.deletePerson(1L);
        assertEquals("Deleted person with id 1", message);
    }
}