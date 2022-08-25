package dev.kotylu.model;

import com.atlassian.jira.user.ApplicationUser;

public class MessageModel {


    private ApplicationUser owner;
    private String message;

    public MessageModel(ApplicationUser owner, String message) {
        this.owner = owner;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public ApplicationUser getOwner() {
        return this.owner;
    }
}
