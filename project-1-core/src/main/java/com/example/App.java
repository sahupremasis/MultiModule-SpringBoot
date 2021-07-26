package com.example;

import com.example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static java.lang.System.exit;


@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private ExampleService exampleService;

    public static void main(String [] args) {
        SpringApplication app = new SpringApplication(App.class);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        exampleService.setName("John");
        exampleService.printHello();
        exit(0);
    }

    private void startExampleService() {
       exampleService.printHello();
    }

}
