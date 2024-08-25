package com.smartdoc.example.model;

/**
 * @author yu 2024/8/23
 */
public class Message {

    /**
     *  message content
     */
    private String content;

    // getter and setter methods
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                '}';
    }
}
