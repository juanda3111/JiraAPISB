package com.jiraAPI.jiraAPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class JiraService {

    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(JiraService.class);

    @Value("${jira.bearer.token}")
    private String bearerToken;

    public JiraService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getIssue(String issueKey) {
        String url = "https://jira.pyur.com/rest/api/2/issue/" + issueKey;
        return restTemplate.getForObject(url, String.class);
    }

    public String createIssue(String projectKey, String summary, String description, String issueType) {
        logger.info("Creating issue with details: projectKey={}, summary={}, description={}, issueType={}",
                projectKey, summary, description, issueType);

        String url = "https://jira.pyur.com/rest/api/2/issue/";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(bearerToken);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode issueDetails = mapper.createObjectNode();
        ObjectNode fields = mapper.createObjectNode();
        ObjectNode project = mapper.createObjectNode();
        ObjectNode issuetype = mapper.createObjectNode();

        project.put("key", projectKey);
        fields.set("project", project);
        fields.put("summary", summary);
        fields.put("description", description);
        issuetype.put("name", issueType);
        fields.set("issuetype", issuetype);
        issueDetails.set("fields", fields);

        try {
            String payload = mapper.writeValueAsString(issueDetails);
            HttpEntity<String> request = new HttpEntity<>(payload, headers);

            String response = restTemplate.postForObject(url, request, String.class);
            logger.info("Issue created successfully: {}", response);
            return response;
        } catch (Exception e) {
            logger.error("Error creating issue: ", e);
            throw new RuntimeException("Error creating issue", e);
        }
    }
}
