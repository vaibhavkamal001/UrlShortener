package com.gigs.logic.url.shortener.write.dto;

import com.gigs.logic.url.shortener.write.model.UrlShort;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
public class CreateShortUrlResponse {
    private String shortCode;
    private String originalUrl;

    public CreateShortUrlResponse(String id, String url) {
    }

    public static ResponseEntity<CreateShortUrlResponse> buildResponse(UrlShort saved) {
        return new ResponseEntity<>(
                new CreateShortUrlResponse(
                        saved.getId(),
                        saved.getUrl()
                ),
                HttpStatus.OK
        );
    }
}