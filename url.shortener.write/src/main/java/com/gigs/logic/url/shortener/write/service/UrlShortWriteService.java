package com.gigs.logic.url.shortener.write.service;

import com.gigs.logic.url.shortener.write.dto.CreateShortUrlRequest;
import com.gigs.logic.url.shortener.write.dto.CreateShortUrlResponse;
import org.springframework.http.ResponseEntity;

public interface UrlShortWriteService {
    ResponseEntity<CreateShortUrlResponse> createShortUrl(CreateShortUrlRequest request);
}