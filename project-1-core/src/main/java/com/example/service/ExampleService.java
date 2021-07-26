package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void printHello() {
        System.out.println("Hello ! " + name);
    }

}
