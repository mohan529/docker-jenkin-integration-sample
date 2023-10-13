package com.docker.image.jenkins.services;

import com.docker.image.jenkins.entities.Person;

import java.util.List;

public interface PersonService {

    Person createPersone(Person person);

    Person getPersonById(String personId);

    List<Person> getAllPerson();

    String deletePersonById(String personId);

    Person updatePersonById(String personId,Person person);

}
