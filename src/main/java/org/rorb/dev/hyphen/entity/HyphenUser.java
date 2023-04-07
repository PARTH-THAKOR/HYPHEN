// HyphenUser Class

package org.rorb.dev.hyphen.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class HyphenUser {

    @Id
    private int id;
    private String time;
    private String message;

    public HyphenUser() {
        super();
    }

    public HyphenUser(int id, String time, String message) {
        this.id = id;
        this.time = time;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
