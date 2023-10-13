package com.docker.image.jenkins.services;

import com.docker.image.jenkins.entities.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {



   public static List<Person> getPersonList(){
       List<Person> list=new ArrayList<>();
       list.add(new Person("1","ram",27,"delhi","docter","male",98979.5));
       list.add(new Person("2","shayam",27,"mumbai","engineer","male",95979.5));
       list.add(new Person("3","hari",27,"uk","solider","male",9897559.5));
       list.add(new Person("4","john",27,"up","farmer","male",938979.5));
       list.add(new Person("5","abhi",27,"mp","water supplier","male",3398979.5));
       list.add(new Person("6","mayank",27,"bangalore","scientist","male",9128979.5));
       return list;


   }
   public static    List<Person> list=getPersonList();

    @Override
    public Person createPersone(Person person) {

       Person response=new Person();
       response.setPersonId(person.getPersonId());
       response.setName(person.getName());
       response.setAge(person.getAge());
       response.setAddress(person.getAddress());
       response.setGender(person.getGender());
       response.setDesignation(person.getDesignation());
       response.setSalay(person.getSalay());
       return response;
    }

    @Override
    public Person getPersonById(String personId) {

          Person person=list.stream().filter(p-> p.getPersonId().equals(personId)).findFirst().get();
        return person;
    }

    @Override
    public List<Person> getAllPerson() {
        return  getPersonList();
    }

    @Override
    public String deletePersonById(String personId) {

        Person person=getPersonList().stream().filter(p-> personId== p.getPersonId()).findFirst().get();
          getPersonList().remove(person);
        return "person data remove successfully!!!";
    }

    @Override
    public Person updatePersonById(String personId,Person person) {
        Person response=getPersonList().stream().filter(p-> personId== p.getPersonId()).findFirst().get();

        response.setName(person.getName());
        response.setAge(person.getAge());
        response.setAddress(person.getAddress());
        response.setDesignation(person.getDesignation());
        response.setGender(person.getGender());
        response.setSalay(person.getSalay());
        return response;
    }
}
