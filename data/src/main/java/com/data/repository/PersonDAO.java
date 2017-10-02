package com.data.repository;

import com.data.model.Person;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
@Profile("database")
public interface PersonDAO extends JpaRepository<Person, Long> {

    List<Person> findAllByFirstname(String firstName);

    List<Person> findAllByName(String name);

    List<Person> findAllByTele(String tele);

    Person findById(long id);


}
