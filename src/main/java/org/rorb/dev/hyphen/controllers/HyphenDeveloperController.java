// HyphenDeveloperController

package org.rorb.dev.hyphen.controllers;

import org.rorb.dev.hyphen.entity.HyphenUser;
import org.rorb.dev.hyphen.repository.DataBaseMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HyphenDeveloperController {

    private final DataBaseMethods MYSQL;

    @Autowired
    public HyphenDeveloperController(DataBaseMethods MYSQL) {
        this.MYSQL = MYSQL;
    }

    @GetMapping("/org.developers.roundrobin/hyphen/dev")
    public ResponseEntity<Iterable<HyphenUser>> getChat() {
        Iterable<HyphenUser> message = MYSQL.findAll();
        return ResponseEntity.of(Optional.of(message));
    }

    @GetMapping("/org.developers.roundrobin/hyphen/dev/{chatId}")
    public ResponseEntity<Iterable<HyphenUser>> getAllUserByChatIdAscending(@PathVariable("chatId") String id) {
        Iterable<HyphenUser> message = MYSQL.findByChatIdOrderByTimeAsc(id);
        return ResponseEntity.of(Optional.of(message));
    }

    @GetMapping("/org.developers.roundrobin/hyphen/dev/desc/{chatId}")
    public ResponseEntity<Iterable<HyphenUser>> getAllChatByChatIdDescending(@PathVariable("chatId") String id) {
        Iterable<HyphenUser> message = MYSQL.findByChatIdOrderByTimeDesc(id);
        return ResponseEntity.of(Optional.of(message));
    }

    @PostMapping("/org.developers.roundrobin/hyphen/dev")
    public ResponseEntity<HyphenUser> postChat(@RequestBody HyphenUser hyphenUser) {
        MYSQL.save(hyphenUser);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/org.developers.roundrobin/hyphen/dev/single/delete/{deleteId}")
    public ResponseEntity<HyphenUser> deleteAllChatByDeleteId(@PathVariable("deleteId") String deleteId) {
        MYSQL.deleteByDeleteId(deleteId);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/org.developers.roundrobin/hyphen/dev/multi/send/{sendId}")
    public ResponseEntity<HyphenUser> deleteAllChatBySendId(@PathVariable("sendId") String sendId) {
        MYSQL.deleteBySendId(sendId);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/org.developers.roundrobin/hyphen/dev/multi/chat/{chatId}")
    public ResponseEntity<HyphenUser> deleteAllChatByChatId(@PathVariable("chatId") String chatId) {
        MYSQL.deleteByChatId(chatId);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/org.developers.roundrobin/hyphen.dev/dev/all/rorb.dev.hyphen")
    public ResponseEntity<HyphenUser> deleteAllChat() {
        MYSQL.deleteAll();
        return ResponseEntity.status(204).build();
    }

}
