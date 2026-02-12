package com.gigs.logic.url.shortener.read.repository;


import com.gigs.logic.url.shortener.read.model.UrlShort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlShortRepository extends JpaRepository<UrlShort, String> {
    Optional<UrlShort> findByUrl(String url);
}
