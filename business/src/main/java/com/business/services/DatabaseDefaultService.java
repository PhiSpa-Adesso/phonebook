package com.business.services;

import com.business.interfaces.MyDatabase;
import com.data.model.Person;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("!database")
public class DatabaseDefaultService implements MyDatabase{

    @Override
    public List<Person> personList() {
        return null;
    }

    @Override
    public List<Person> searc(Person person) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Person findById(long id) {
        return null;
    }

    @Override
    public void save(Person person) {

    }

    @Override
    public void overWrite(Person oldPerson, Person newPerson) {

    }
}
