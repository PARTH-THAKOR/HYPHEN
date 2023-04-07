// HyphenUser Class

package org.rorb.dev.hyphen.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class HyphenUser {

    @Id
    private String ID;
    private String time;
    private String message;

    public HyphenUser() {
        super();
    }

    public HyphenUser(String ID, String time, String message) {
        this.ID = ID;
        this.time = time;
        this.message = message;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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
