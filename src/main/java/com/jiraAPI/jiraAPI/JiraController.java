package com.jiraAPI.jiraAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jira")
public class JiraController {

    private final JiraService jiraService;

    public JiraController(JiraService jiraService) {
        this.jiraService = jiraService;
    }

    @GetMapping("/{issueKey}")
    public String getIssue(@PathVariable String issueKey) {
        return jiraService.getIssue(issueKey);
    }

    @PostMapping("/issue/{summary}")
    public String createIssue(@PathVariable String summary) {
        String projectKey = "SFSI"; // El key del proyecto en Jira
        String description = "Created from Spring Boot";
        String issueType = "Bug"; // El tipo de issue en Jira
        return jiraService.createIssue(projectKey, summary, description, issueType);
    }
}
