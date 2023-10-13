package com.docker.image.jenkins.controller;

import com.docker.image.jenkins.entities.Person;
import com.docker.image.jenkins.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class DemoController {


    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){

        return new ResponseEntity<Person>(personService.createPersone(person),HttpStatus.CREATED);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Person> getPersonById(@PathVariable String personId){
        return new ResponseEntity<Person>(personService.getPersonById(personId),HttpStatus.OK);
    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<Person> updatePersonById(@PathVariable String personId,@RequestBody Person person){
        return new ResponseEntity<Person>(personService.updatePersonById(personId,person),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllperson(){
        return new ResponseEntity<List<Person>>(personService.getAllPerson(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<String> deletePersonById(@PathVariable String personId){
        return new ResponseEntity<String>(personService.deletePersonById(personId),HttpStatus.OK);
    }

    @GetMapping
    public String display(){
        return "say hello";
    }
}
