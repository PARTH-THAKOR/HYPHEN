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

    @GetMapping("/org.roundrobin/hyphen/dev/{projectName}")
    public ResponseEntity<Iterable<HyphenUser>> getAllUserChatByProjectIdAscending(@PathVariable("projectName") String projectName) {
        Iterable<HyphenUser> message = MYSQL.findByProjectNameOrderByTimeAsc(projectName);
        return ResponseEntity.of(Optional.of(message));
    }

    @DeleteMapping("/org.roundrobin/hyphen/dev/{projectName}")
    public ResponseEntity<HyphenUser> deleteAllChatByProjectName(@PathVariable("projectName") String projectName) {
        MYSQL.deleteByProjectName(projectName);
        return ResponseEntity.status(204).build();
    }

}
