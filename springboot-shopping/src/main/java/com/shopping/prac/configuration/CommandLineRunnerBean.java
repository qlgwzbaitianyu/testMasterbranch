package com.shopping.prac.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerBean implements CommandLineRunner {

    @Value("${name}")
    private String name;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@ in the command line runner ! " + name);
    }
}
