// HyphenUser Class

package org.rorb.dev.hyphen.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
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

}
