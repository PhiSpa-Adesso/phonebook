package com.business.services;

import com.data.model.Person;
import com.data.reposetory.PersonDAO;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class ShowService {

    @Autowired
    PersonDAO personDAO;

    public List<Person> personList(){
        return  personDAO.findAll();
    }

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

    public void delete(long id){
        personDAO.delete(id);
    }

    public Person findById(long id){
        return personDAO.findById(id);
    }

}
