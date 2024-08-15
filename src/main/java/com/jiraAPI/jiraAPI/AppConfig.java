package com.jiraAPI.jiraAPI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Value("${jira.bearer.token}")
    private String bearerToken;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .additionalInterceptors(bearerTokenInterceptor())
                .build();
    }

    private ClientHttpRequestInterceptor bearerTokenInterceptor() {
        return (request, body, execution) -> {
            request.getHeaders().setBearerAuth(bearerToken);
            return execution.execute(request, body);
        };
    }
}
