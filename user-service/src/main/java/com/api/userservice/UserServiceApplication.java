package com.api.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class UserServiceApplication {
    @Autowired
    @Lazy
    private RestTemplate restTemplate;


    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @GetMapping(value = "dept", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getSomething(){
        ResponseEntity<String> responseEntity = restTemplate
                .getForEntity("http://DEPARTMENT-SERVICE/api/departments",
                        String.class);


        return responseEntity;
    }


    @Bean("lazy")
    @LoadBalanced
    public RestTemplate restTemplate () {
        return  new  RestTemplate ();
    }


}
