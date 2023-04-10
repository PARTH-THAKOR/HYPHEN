// HyphenUser Class

package org.rorb.dev.hyphen.entity;

import jakarta.persistence.*;

@Entity
public class HyphenUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String projectName;
    private String chatId;
    private String sendId;
    private String deleteId;
    private String time;
    private String message;

    public HyphenUser() {
        super();
    }

    public HyphenUser(int id, String projectName, String chatId, String sendId, String deleteId, String time, String message) {
        this.id = id;
        this.projectName = projectName;
        this.chatId = chatId;
        this.sendId = sendId;
        this.deleteId = deleteId;
        this.time = time;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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
