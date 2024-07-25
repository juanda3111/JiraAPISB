package com.jiraAPI.jiraAPI;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class AppConfig {

    private static final String BEARER_TOKEN = "";
    //private static final String BEARER_TOKEN = "ODE4MjQxMjE5Nzk5OkLRSI4G/fITfcAxc8celW/GEpOi";

    
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .additionalInterceptors(bearerTokenInterceptor())
                .build();
    }

    private ClientHttpRequestInterceptor bearerTokenInterceptor() {
        return (request, body, execution) -> {
            request.getHeaders().setBearerAuth(BEARER_TOKEN);
            return execution.execute(request, body);
        };
    }
}
