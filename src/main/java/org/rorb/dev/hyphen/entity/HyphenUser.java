// HyphenUser Class

package org.rorb.dev.hyphen.entity;

import jakarta.persistence.*;
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
