package com.postgres.service;

import com.postgres.model.PersonEntity;
import com.postgres.repository.PersonRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Transactional
    public void housekeepPerson() {
        System.out.println("Housekeeping for Person started");
        List<PersonEntity> personEntityList = personRepository.findAll();
        System.out.println(personEntityList);

        List<PersonEntity> allpersonEntityList = personRepository.findAllPersons();
        System.out.println(allpersonEntityList);

        List<PersonEntity> objects = (List<PersonEntity>)personRepository.findPersonsByName("John");
        System.out.println(personEntityList);

        Instant instant = Instant.now().minus(20, ChronoUnit.DAYS).truncatedTo(ChronoUnit.DAYS);
        System.out.println("Finding persons older than created on instant: " + instant);
        List<PersonEntity> personsCreatedOnOlderThan = personRepository.findPersonsCreatedOnOlderThan(instant);
        System.out.println(personsCreatedOnOlderThan);

        instant = Instant.now().minus(700, ChronoUnit.DAYS).truncatedTo(ChronoUnit.DAYS);
        System.out.println("Finding persons older than created on instant: " + instant);
        List<PersonEntity> personsCreatedOnOlderThan700Days = personRepository.findPersonsCreatedOnOlderThan(instant);
        System.out.println(personsCreatedOnOlderThan700Days);

        deleteOlderThan(instant);
    }

    private void deleteOlderThan(Instant instant) {
        System.out.println("Deleting persons older than created on instant: " + instant);
        personRepository.deletePersonsCreatedOnOlderThan(instant);
        System.out.println("Deletion complete");
    }

}
