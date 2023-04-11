// HyphenDeveloperController

package org.rorb.dev.hyphen.controllers;

import org.rorb.dev.hyphen.entity.HyphenUser;
import org.rorb.dev.hyphen.repository.DataBaseMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
public class HyphenDeveloperController {

    private final DataBaseMethods MYSQL;

    @Autowired
    public HyphenDeveloperController(DataBaseMethods MYSQL) {
        this.MYSQL = MYSQL;
    }

    @GetMapping("/org.roundrobin/hyphen/dev/{projectName}")
    public ResponseEntity<Iterable<HyphenUser>> getAllUserChatByProjectIdAscending(@PathVariable("projectName") String projectName, @RequestHeader(value = "UserName") String userName, @RequestHeader(value = "Password") String password) {
        if (Objects.equals(userName, projectName)) {
            if (password.length() == 17 && password.charAt(4) == 'p' && password.charAt(7) == 'a' && password.charAt(8) == 'r' && password.charAt(11) == 't' && password.charAt(15) == 'h' && password.charAt(16) == 'n') {
                Iterable<HyphenUser> message = MYSQL.findByProjectNameOrderByTimeAsc(projectName);
                return ResponseEntity.of(Optional.of(message));
            } else {
                return ResponseEntity.status(401).build();
            }
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping("/org.roundrobin/hyphen/dev/{projectName}")
    public ResponseEntity<HyphenUser> postChat(@RequestBody HyphenUser hyphenUser, @PathVariable("projectName") String projectName, @RequestHeader(value = "UserName") String userName, @RequestHeader(value = "Password") String password) {
        if (Objects.equals(userName, projectName)) {
            if (password.length() == 17 && password.charAt(4) == 'p' && password.charAt(7) == 'a' && password.charAt(8) == 'r' && password.charAt(11) == 't' && password.charAt(15) == 'h' && password.charAt(16) == 'n') {
                MYSQL.save(hyphenUser);
                return ResponseEntity.status(201).build();
            } else {
                return ResponseEntity.status(401).build();
            }
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @DeleteMapping("/org.roundrobin/hyphen/dev/{projectName}")
    public ResponseEntity<HyphenUser> deleteAllChatByProjectName(@PathVariable("projectName") String projectName, @RequestHeader(value = "UserName") String userName, @RequestHeader(value = "Password") String password) {
        if (Objects.equals(userName, projectName)) {
            if (password.length() == 17 && password.charAt(4) == 'p' && password.charAt(7) == 'a' && password.charAt(8) == 'r' && password.charAt(11) == 't' && password.charAt(15) == 'h' && password.charAt(16) == 'n') {
                MYSQL.deleteByProjectName(projectName);
                return ResponseEntity.status(204).build();
            } else {
                return ResponseEntity.status(401).build();
            }
        } else {
            return ResponseEntity.status(401).build();
        }
    }

}
