package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Hello world!
 *
 */

@SpringBootApplication

// Class
@RequestMapping("/api/alert")
public class App 
{
    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }

    @RequestMapping("/test1")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
