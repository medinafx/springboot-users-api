package com.nisum.users.controller.validation;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValidationError {

    private String path;
    private String message;
    private List<String> messages;

    public ValidationError(String message) {
        this(null, message, null);
    }

    public ValidationError(List<String> messages) {
        this(null, null, messages);
    }

    public ValidationError(String path, String message, List<String> messages) {
        this.path = path;
        this.message = message;
        this.messages = messages;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
