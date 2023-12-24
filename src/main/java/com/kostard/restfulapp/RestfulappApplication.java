package com.kostard.restfulapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestfulappApplication {
    private static final Logger log = LoggerFactory.getLogger(RestfulappApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(RestfulappApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
            bookRepository.save(new Book("1984", "George Orwell"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            bookRepository.findAll().forEach(book -> {
                log.info(book.toString());
            });
            log.info("");
        };
    }
}

