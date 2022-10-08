package com.api.departmentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("api")
public class DepartmentServiceApplication {
    @Autowired
    Environment environment;


    public static void main(String[] args) {
        SpringApplication.run(DepartmentServiceApplication.class, args);
    }

    @GetMapping(value = "departments", produces = MediaType.TEXT_PLAIN_VALUE)
    public String helloWorld(){
        return "Hello World: "+environment.getProperty("local.server.port");
    }
}
