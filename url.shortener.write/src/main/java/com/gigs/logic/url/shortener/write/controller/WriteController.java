package com.gigs.logic.url.shortener.write.controller;


import com.gigs.logic.url.shortener.write.dto.CreateShortUrlRequest;
import com.gigs.logic.url.shortener.write.dto.CreateShortUrlResponse;
import com.gigs.logic.url.shortener.write.service.UrlShortWriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class WriteController {

    private final UrlShortWriteService urlShortWriteService;

    public WriteController(UrlShortWriteService urlShortWriteService) {
        this.urlShortWriteService = urlShortWriteService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateShortUrlResponse> createShortUrl(@RequestBody CreateShortUrlRequest createShortUrlRequest){
        return urlShortWriteService.createShortUrl(createShortUrlRequest);
    }
}
