// HyphenUser Class

package org.rorb.dev.hyphen.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class HyphenUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String projectName;
    private String chatId;
    private String sendId;
    private String deleteId;
    private String time;
    private String message;

}
