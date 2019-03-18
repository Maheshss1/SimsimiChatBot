package com.example.mahesh.simsimichatbot.model;

public class ChatModel {
    private String chatMessage;
    private boolean isSend;

    public ChatModel(String chatMessage, boolean isSend) {
        this.chatMessage = chatMessage;
        this.isSend = isSend;
    }

    public String getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }
}
