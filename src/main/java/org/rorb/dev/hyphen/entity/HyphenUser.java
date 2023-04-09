// HyphenUser Class

package org.rorb.dev.hyphen.entity;

import jakarta.persistence.*;

@Entity
public class HyphenUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String chatId;
    private String sendId;
    private String deleteId;
    private String time;
    private String message;

    public HyphenUser() {
        super();
    }

    public HyphenUser(int id, String chatId, String time, String message) {
        this.id = id;
        this.chatId = chatId;
        this.time = time;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(String deleteId) {
        this.deleteId = deleteId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
