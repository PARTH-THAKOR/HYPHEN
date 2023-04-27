// HyphenUserController

package org.rorb.dev.hyphen.controllers;

import org.rorb.dev.hyphen.entity.HyphenUser;
import org.rorb.dev.hyphen.repository.DataBaseMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
public class HyphenUserController {

    private final DataBaseMethods MYSQL;

    @Autowired
    public HyphenUserController(DataBaseMethods MYSQL) {
        this.MYSQL = MYSQL;
    }

    @GetMapping("/org.roundrobin/hyphen/{projectName}/user/{chatId}/asc")
    public ResponseEntity<Iterable<HyphenUser>> getAllUserByChatIdAscending(@PathVariable("projectName") String projectName, @PathVariable("chatId") String chatId, @RequestHeader(value = "UserName") String userName, @RequestHeader(value = "Password") String password) {
        if (Objects.equals(userName, projectName)) {
            if (Password.passWord(password)) {
                Iterable<HyphenUser> message = MYSQL.findByProjectNameAndChatIdOrderByTimeAsc(projectName, chatId);
                return ResponseEntity.of(Optional.of(message));
            } else {
                return ResponseEntity.status(401).build();
            }
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @GetMapping("/org.roundrobin/hyphen/{projectName}/user/{chatId}/desc")
    public ResponseEntity<Iterable<HyphenUser>> getAllUserByChatIdDescending(@PathVariable("projectName") String projectName, @PathVariable("chatId") String chatId, @RequestHeader(value = "UserName") String userName, @RequestHeader(value = "Password") String password) {
        if (Objects.equals(userName, projectName)) {
            if (Password.passWord(password)) {
                Iterable<HyphenUser> message = MYSQL.findByProjectNameAndChatIdOrderByTimeDesc(projectName, chatId);
                return ResponseEntity.of(Optional.of(message));
            } else {
                return ResponseEntity.status(401).build();
            }
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping("/org.roundrobin/hyphen/user/{projectName}/post")
    public ResponseEntity<HyphenUser> postChat(@RequestBody HyphenUser hyphenUser, @PathVariable("projectName") String projectName, @RequestHeader(value = "UserName") String userName, @RequestHeader(value = "Password") String password) {
        if (Objects.equals(userName, projectName)) {
            if (Password.passWord(password)) {
                MYSQL.save(hyphenUser);
                return ResponseEntity.status(201).build();
            } else {
                return ResponseEntity.status(401).build();
            }
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @DeleteMapping("/org.roundrobin/hyphen/{projectName}/user/single/delete/{deleteId}")
    public ResponseEntity<HyphenUser> deleteAllChatByDeleteId(@PathVariable("projectName") String projectName, @PathVariable("deleteId") String deleteId, @RequestHeader(value = "UserName") String userName, @RequestHeader(value = "Password") String password) {
        if (Objects.equals(userName, projectName)) {
            if (Password.passWord(password)) {
                MYSQL.deleteByProjectNameAndDeleteId(projectName, deleteId);
                return ResponseEntity.status(204).build();
            } else {
                return ResponseEntity.status(401).build();
            }
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @DeleteMapping("/org.roundrobin/hyphen/{projectName}/user/multi/send/{sendId}")
    public ResponseEntity<HyphenUser> deleteAllChatBySendId(@PathVariable("projectName") String projectName, @PathVariable("sendId") String sendId, @RequestHeader(value = "UserName") String userName, @RequestHeader(value = "Password") String password) {
        if (Objects.equals(userName, projectName)) {
            if (Password.passWord(password)) {
                MYSQL.deleteByProjectNameAndSendId(projectName, sendId);
                return ResponseEntity.status(204).build();
            } else {
                return ResponseEntity.status(401).build();
            }
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @DeleteMapping("/org.roundrobin/hyphen/{projectName}/user/multi/chat/{chatId}")
    public ResponseEntity<HyphenUser> deleteAllChatByChatId(@PathVariable("projectName") String projectName, @PathVariable("chatId") String chatId, @RequestHeader(value = "UserName") String userName, @RequestHeader(value = "Password") String password) {
        if (Objects.equals(userName, projectName)) {
            if (Password.passWord(password)) {
                MYSQL.deleteByProjectNameAndChatId(projectName, chatId);
                return ResponseEntity.status(204).build();
            } else {
                return ResponseEntity.status(401).build();
            }
        } else {
            return ResponseEntity.status(401).build();
        }
    }

}
