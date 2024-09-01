package com.chassi.generics.controller;

import com.chassi.generics.exceptions.ResourceNotFoundException;
import com.chassi.generics.model.Person;
import com.chassi.generics.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    private Logger logger = Logger.getLogger(PersonController.class.getName());

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        logger.info("finding all persons;");
        List<Person> persons = personService.findAll();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        try {
            logger.info("finding by id " + id);
            Person person = personService.findById(id);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        try {
            logger.info("create person  person " + person.toString());
            Person createdPerson = personService.save(person);
            return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable Long id) {
        try {
            logger.info("update person  person " + person.toString());
            Person updatedPerson = personService.update(person, id);
            return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable Long id) {
        try {
            logger.info("deletePerson  id " + id);
            personService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
