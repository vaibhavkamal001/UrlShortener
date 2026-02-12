package com.gigs.logic.url.shortener.read.service.impl;

import com.gigs.logic.url.shortener.read.model.UrlShort;
import com.gigs.logic.url.shortener.read.repository.UrlShortRepository;
import com.gigs.logic.url.shortener.read.service.UrlShortReadService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UrlShortReadServiceImpl implements UrlShortReadService {

    private final UrlShortRepository urlShortRepository;

    public UrlShortReadServiceImpl(UrlShortRepository urlShortRepository) {
        this.urlShortRepository = urlShortRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public String findShortUrl(String id) {

        UrlShort urlShort = urlShortRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Short URL not found"));

        if (urlShort.isExpired()) {
            throw new EntityNotFoundException("Short URL has expired");
        }

        return urlShort.getUrl();
    }


}