package com.jiraAPI.jiraAPI;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JiraService {

    private final RestTemplate restTemplate;

    public JiraService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getIssue(String issueKey) {
        String url = "https://jira.pyur.com/rest/api/2/issue/" + issueKey;
        return restTemplate.getForObject(url, String.class);
    }

    public String createIssue(String issueDetails) {
        String url = "https://jira.pyur.com/rest/api/2/issue";
        return restTemplate.postForObject(url, issueDetails, String.class);
    }
}
