// HyphenSuperDeveloperController

package org.rorb.dev.hyphen.controllers;

import org.rorb.dev.hyphen.entity.HyphenUser;
import org.rorb.dev.hyphen.repository.DataBaseMethods;
import org.rorb.dev.hyphen.security.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HyphenSuperDeveloperController {

    private final DataBaseMethods MYSQL;

    @Autowired
    public HyphenSuperDeveloperController(DataBaseMethods MYSQL) {
        this.MYSQL = MYSQL;
    }

    @GetMapping("/org.roundrobin/hyphen/super/dev/password/38")
    public ResponseEntity<Iterable<HyphenUser>> getAllData(@RequestHeader(value = "UserName") String userName, @RequestHeader(value = "Password") String password) {
        if (Password.passWordSuperDev(userName, password)) {
            Iterable<HyphenUser> message = MYSQL.findAll();
            return ResponseEntity.of(Optional.of(message));
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping("/org.roundrobin/hyphen/super/dev")
    public ResponseEntity<HyphenUser> postChat(@RequestBody HyphenUser hyphenUser, @RequestHeader(value = "UserName") String userName, @RequestHeader(value = "Password") String password) {
        if (Password.passWordSuperDev(userName, password)) {
            MYSQL.save(hyphenUser);
            return ResponseEntity.status(201).build();
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @DeleteMapping("/org.roundrobin/hyphen/super/dev/all/rorb.dev.hyphen/password/38")
    public ResponseEntity<HyphenUser> deleteAllData(@RequestHeader(value = "UserName") String userName, @RequestHeader(value = "Password") String password) {
        if (Password.passWordSuperDev(userName, password)) {
            MYSQL.deleteAll();
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(401).build();
        }
    }

}
