package com.gigs.logic.url.shortener.write.service.impl;

import com.gigs.logic.url.shortener.write.dto.CreateShortUrlRequest;
import com.gigs.logic.url.shortener.write.dto.CreateShortUrlResponse;
import com.gigs.logic.url.shortener.write.model.UrlShort;
import com.gigs.logic.url.shortener.write.repository.UrlShortRepository;
import com.gigs.logic.url.shortener.write.service.UrlShortWriteService;
import com.gigs.logic.url.shortener.write.util.ShortIdGenerator;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UrlShortWriteServiceImpl implements UrlShortWriteService {

    private final UrlShortRepository urlShortRepository;

    public UrlShortWriteServiceImpl(UrlShortRepository urlShortRepository) {
        this.urlShortRepository = urlShortRepository;
    }

    @Override
    @Transactional
    public ResponseEntity<CreateShortUrlResponse> createShortUrl(CreateShortUrlRequest request) {
        request.validate();
        int attempts = 0;
        while (attempts < 3) {
            try {

                UrlShort entity = UrlShort.create(request, ShortIdGenerator.generate());
                UrlShort saved = urlShortRepository.save(entity);

                return CreateShortUrlResponse.buildResponse(saved);

            } catch (DataIntegrityViolationException ex) {
                attempts++;
            }
        }

        throw new IllegalStateException("Failed to generate unique short URL");
    }

}