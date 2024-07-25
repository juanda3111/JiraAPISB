package com.jiraAPI.jiraAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;



@SpringBootApplication
@RestController
public class JiraApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JiraApiApplication.class, args);
	}
	
	@GetMapping("/hello")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	

  /**  @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
**/

}
