// HyphenSuperDeveloperController

package org.rorb.dev.hyphen.controllers;

import org.rorb.dev.hyphen.entity.HyphenUser;
import org.rorb.dev.hyphen.repository.DataBaseMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HyphenSuperDeveloperController {

    private final DataBaseMethods MYSQL;

    @Autowired
    public HyphenSuperDeveloperController(DataBaseMethods MYSQL) {
        this.MYSQL = MYSQL;
    }

    @GetMapping("/org.roundrobin/hyphen/super/dev/password/38")
    public ResponseEntity<Iterable<HyphenUser>> getAllData() {
        Iterable<HyphenUser> message = MYSQL.findAll();
        return ResponseEntity.of(Optional.of(message));
    }

    @DeleteMapping("/org.roundrobin/hyphen.dev/super/dev/all/rorb.dev.hyphen/password/38")
    public ResponseEntity<HyphenUser> deleteAllData() {
        MYSQL.deleteAll();
        return ResponseEntity.status(204).build();
    }

}
