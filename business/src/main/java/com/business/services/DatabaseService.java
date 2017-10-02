package com.business.services;

import com.business.interfaces.MyDatabase;
import com.data.model.Person;
import com.data.model.Strings;
import com.data.repository.PersonDAO;
import com.data.repository.StringDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
@Profile("database")
public class DatabaseService implements MyDatabase {

    @Autowired
    PersonDAO personDAO;

    //----------------------------- show --------------------------------
    @Override
    public List<Person> personList(){
        return  personDAO.findAll();
    }

    @Override
    public List<Person> searc(Person person){
        List<Person> result = new ArrayList<>();
        result.addAll(personDAO.findAllByName(person.getName()));
        result.addAll(personDAO.findAllByFirstname(person.getFirstname()));
        result.addAll(personDAO.findAllByTele(person.getTele()));
        return removeDuplicats(result);
    }

    private List<Person> removeDuplicats(List<Person> personList){
        List<Person> result = new ArrayList<>();
        for (Person person:personList
             ) {
            if (!result.contains(person)){result.add(person);}
        }
        return result;
    }

    @Override
    public void delete(long id){
        personDAO.delete(id);
    }

    @Override
    public Person findById(long id){
        return personDAO.findById(id);
    }



    //----------------------------- create --------------------------------
    @Override
    public void save(Person person){
        personDAO.save(person);
    }

    @Override
    public void overWrite(Person oldPerson, Person newPerson){
        oldPerson.setFirstname(newPerson.getFirstname());
        oldPerson.setName(newPerson.getName());
        oldPerson.setTele(newPerson.getTele());
        personDAO.save(oldPerson);
    }


}
