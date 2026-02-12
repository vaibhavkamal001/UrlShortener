package com.gigs.logic.url.shortener.read.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<Object> health(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
