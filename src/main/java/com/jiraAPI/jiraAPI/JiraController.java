package com.jiraAPI.jiraAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/issue")
    public String createIssue(@RequestBody String issueDetails) {
        return jiraService.createIssue(issueDetails);
    }
}
