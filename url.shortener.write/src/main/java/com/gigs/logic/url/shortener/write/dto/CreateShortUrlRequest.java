package com.gigs.logic.url.shortener.write.dto;

import com.gigs.logic.url.shortener.write.util.UrlValidator;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class CreateShortUrlRequest {

    private String url;

    private Long ttlValue;

    private ChronoUnit ttlUnit;

    public void validate() {

        if (this.getUrl() == null || !UrlValidator.isValid(this.getUrl())) {
            throw new IllegalArgumentException("Invalid URL");
        }

        if (this.getTtlValue() != null || this.getTtlUnit() != null) {

            if (this.getTtlValue() == null || this.getTtlUnit() == null) {
                throw new IllegalArgumentException("Both ttlValue and ttlUnit must be provided together");
            }

            if (this.getTtlValue() <= 0) {
                throw new IllegalArgumentException("ttlValue must be greater than 0");
            }
        }
    }

    public LocalDateTime calculateExpiry() {
        if (this.getTtlValue() != null && this.getTtlUnit() != null) {
            return LocalDateTime.now()
                    .plus(this.getTtlValue(), this.getTtlUnit());
        }
        return null;
    }
}