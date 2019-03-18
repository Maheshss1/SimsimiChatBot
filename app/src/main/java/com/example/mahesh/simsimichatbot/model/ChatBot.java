package com.example.mahesh.simsimichatbot.model;

public class ChatBot {
    private int id;
    private int result;
    private String msg;
    private String response;

    public ChatBot(int id, int result, String msg, String response) {
        this.id = id;
        this.result = result;
        this.msg = msg;
        this.response = response;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getmsg() {
        return msg;
    }

    public void setmsg(String msg) {
        this.msg = msg;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
