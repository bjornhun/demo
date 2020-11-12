package com.example.demo.validation;

import com.example.demo.enitity.Person;
import com.example.demo.exception.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class PersonValidator {

    public void validatePerson(Person person) {
        if (person.getAge() < 0) {
            throw new ValidationException("Age cannot be less than 0");
        }
    }
}
