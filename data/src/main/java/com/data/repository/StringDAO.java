package com.data.repository;

import com.data.model.Strings;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
@Profile("strings")
public interface StringDAO extends JpaRepository<Strings, Long> {

    Strings getByName(String name);

}
