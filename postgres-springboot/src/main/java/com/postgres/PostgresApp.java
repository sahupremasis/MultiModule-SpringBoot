package com.postgres;

import com.postgres.controller.DbHousekeepingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostgresApp implements CommandLineRunner {

    @Autowired
    private DbHousekeepingController dbHousekeepingController;

    public static void main(String[] args) {
        SpringApplication.run(PostgresApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");
        dbHousekeepingController.startHousekeeping();
    }
}
