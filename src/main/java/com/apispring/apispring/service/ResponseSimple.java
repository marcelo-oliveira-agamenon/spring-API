package com.apispring.apispring.service;

public class ResponseSimple {
    private String textResponse;

    public String getTextResponse() {
        return textResponse;
    }

    public ResponseSimple(String textResponse) {
        this.textResponse = textResponse;
    }

    public void setTextResponse(String textResponse) {
        this.textResponse = textResponse;
    }
}
