// HyphenUserController

package org.rorb.dev.hyphen.controllers;

import org.rorb.dev.hyphen.entity.HyphenUser;
import org.rorb.dev.hyphen.repository.DataBaseMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HyphenUserController {


    private final DataBaseMethods MYSQL;

    @Autowired
    public HyphenUserController(DataBaseMethods MYSQL) {
        this.MYSQL = MYSQL;
    }

    @GetMapping("/org.roundrobin/hyphen/{projectName}/user/{chatId}/asc")
    public ResponseEntity<Iterable<HyphenUser>> getAllUserByChatIdAscending(@PathVariable("projectName") String projectName, @PathVariable("chatId") String chatId) {
        Iterable<HyphenUser> message = MYSQL.findByProjectNameAndChatIdOrderByTimeAsc(projectName, chatId);
        return ResponseEntity.of(Optional.of(message));
    }

    @GetMapping("/org.roundrobin/hyphen/{projectName}/user/{chatId}/desc")
    public ResponseEntity<Iterable<HyphenUser>> getAllUserByChatIdDescending(@PathVariable("projectName") String projectName, @PathVariable("chatId") String chatId) {
        Iterable<HyphenUser> message = MYSQL.findByProjectNameAndChatIdOrderByTimeDesc(projectName, chatId);
        return ResponseEntity.of(Optional.of(message));
    }

    @PostMapping("/org.roundrobin/hyphen/user")
    public ResponseEntity<HyphenUser> postChat(@RequestBody HyphenUser hyphenUser) {
        MYSQL.save(hyphenUser);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/org.roundrobin/hyphen/{projectName}/user/single/delete/{deleteId}")
    public ResponseEntity<HyphenUser> deleteAllChatByDeleteId(@PathVariable("projectName") String projectName, @PathVariable("deleteId") String deleteId) {
        MYSQL.deleteByProjectNameAndDeleteId(projectName, deleteId);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/org.roundrobin/hyphen/{projectName}/user/multi/send/{sendId}")
    public ResponseEntity<HyphenUser> deleteAllChatBySendId(@PathVariable("projectName") String projectName, @PathVariable("sendId") String sendId) {
        MYSQL.deleteByProjectNameAndSendId(projectName, sendId);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/org.roundrobin/hyphen/{projectName}/user/multi/chat/{chatId}")
    public ResponseEntity<HyphenUser> deleteAllChatByChatId(@PathVariable("projectName") String projectName, @PathVariable("chatId") String chatId) {
        MYSQL.deleteByProjectNameAndChatId(projectName, chatId);
        return ResponseEntity.status(204).build();
    }

}
