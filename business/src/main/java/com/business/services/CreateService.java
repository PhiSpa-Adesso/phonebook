package com.business.services;


import com.data.model.Person;
import com.data.reposetory.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateService {

    @Autowired
    private PersonDAO personDAO;

    public void save(Person person){
        personDAO.save(person);
    }

    public void overWrite(Person oldPerson, Person newPerson){
        oldPerson.setFirstname(newPerson.getFirstname());
        oldPerson.setName(newPerson.getName());
        oldPerson.setTele(newPerson.getTele());
        personDAO.save(oldPerson);
    }

}
