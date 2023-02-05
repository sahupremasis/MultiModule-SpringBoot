package com.postgres.controller;

import com.postgres.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DbHousekeepingController {

    @Autowired
    private PersonService personService;

    public void startHousekeeping() {
        personService.housekeepPerson();

        // Add implementation for other tables

    }

}
