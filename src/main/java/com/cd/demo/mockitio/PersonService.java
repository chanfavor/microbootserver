package com.cd.demo.mockitio;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class PersonService {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private PersonDao personDao2;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public PersonService() {

    }

    public Person getPerson(Integer id) {
        return personDao.getPersonById(id);
    }

    public boolean updatePerson(Integer id) {

        System.out.println(new Random().nextInt());
        return personDao.updatePersonById(id);
    }

    public Person getPerson2 (Integer id) {

        return personDao2.getPersonById(id);
    }
}
