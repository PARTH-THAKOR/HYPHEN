// HyphenControllers

package org.rorb.dev.hyphen.controllers;

import org.rorb.dev.hyphen.entity.HyphenUser;
import org.rorb.dev.hyphen.repository.DataBaseMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HyphenControllers {

    private final DataBaseMethods MYSQL;

    @Autowired
    public HyphenControllers(DataBaseMethods MYSQL) {
        this.MYSQL = MYSQL;
    }

    @GetMapping("/org.developers.roundrobin/hyphen")
    public ResponseEntity<Iterable<HyphenUser>> getChat() {
        Iterable<HyphenUser> message = MYSQL.findAll();
        return ResponseEntity.of(Optional.of(message));
    }

    @PostMapping("/org.developers.roundrobin/hyphen")
    public ResponseEntity<HyphenUser> postChat(@RequestBody HyphenUser hyphenUser) {
        MYSQL.save(hyphenUser);
        return ResponseEntity.status(201).build();
    }

}
