package ru.galeev.firstspringbootapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.galeev.firstspringbootapp.models.Person;
import ru.galeev.firstspringbootapp.repositories.PeopleRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Person findByName(String name) {
        Optional<Person> foundPerson = peopleRepository.findByName(name);
        return foundPerson.orElse(null);
    }
}
