package com.business.interfaces;

import com.data.model.Person;

import java.util.List;

public interface MyDatabase {

    //show
    List<Person> personList();
    List<Person> searc(Person person);
    void delete(long id);
    Person findById(long id);


    //create
    void save(Person person);
    void overWrite(Person oldPerson, Person newPerson);

}
