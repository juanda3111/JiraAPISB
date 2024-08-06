package com.jiraAPI.jiraAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class JiraApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiraApiApplication.class, args);
    }

    @GetMapping("/")
	public String index() {
		return "Spring Boot is up and running! ";
	}
   /** @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }*/
}
