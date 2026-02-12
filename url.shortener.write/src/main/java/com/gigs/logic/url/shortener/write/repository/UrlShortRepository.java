package com.gigs.logic.url.shortener.write.repository;

import com.gigs.logic.url.shortener.write.model.UrlShort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlShortRepository extends JpaRepository<UrlShort, String> {
    Optional<UrlShort> findByUrl(String url);
}
