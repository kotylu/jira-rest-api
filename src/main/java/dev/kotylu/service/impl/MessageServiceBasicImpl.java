package dev.kotylu.service.impl;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.IssueManager;
import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import dev.kotylu.model.MessageModel;
import dev.kotylu.service.api.MessageService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@ExportAsService
@Component
@Named("basic")
public class MessageServiceBasicImpl implements MessageService {

    @Autowired
    private IssueManager issueManager;

    public MessageServiceBasicImpl(@ComponentImport IssueManager issueManager) {
        this.issueManager = issueManager;
    }

    @Override
    public MessageModel getMessage(String issueKey) throws NotFoundException {
        Issue issue = this.issueManager.getIssueByCurrentKey(issueKey);
        if (issue == null) {
            throw new NotFoundException("issue was not found");
        }
        return new MessageModel(issue.getReporter(), issue.getSummary());
    }
}
