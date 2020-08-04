package com.apispring.apispring.service;

import com.apispring.apispring.models.User;

public class ResponseWithJson {
    private String textResponse;
    private User user;

    public ResponseWithJson(String textResponse, User user) {
        this.textResponse = textResponse;
        this.user = user;
    }

    public String getTextResponse() {
        return textResponse;
    }

    public void setTextResponse(String textResponse) {
        this.textResponse = textResponse;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
