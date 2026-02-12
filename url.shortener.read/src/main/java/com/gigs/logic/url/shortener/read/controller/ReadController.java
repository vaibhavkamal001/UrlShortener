package com.gigs.logic.url.shortener.read.controller;


import com.gigs.logic.url.shortener.read.service.UrlShortReadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class ReadController {

    private final UrlShortReadService urlShortReadService;

    public ReadController(UrlShortReadService urlShortReadService) {
        this.urlShortReadService = urlShortReadService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> redirect(@PathVariable String id) {

        String originalUrl = urlShortReadService.findShortUrl(id);

        return ResponseEntity
                .status(HttpStatus.PERMANENT_REDIRECT)
                .location(URI.create(originalUrl))
                .build();
    }
}
