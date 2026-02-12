package com.gigs.logic.url.shortener.write.model;

import com.gigs.logic.url.shortener.write.dto.CreateShortUrlRequest;
import com.gigs.logic.url.shortener.write.util.ShortIdGenerator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "url_short")
public class UrlShort {

    @Id
    @Column(length = 20)
    private String id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String url;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public UrlShort() {
    }

    public UrlShort(String id, String url, LocalDateTime expiresAt) {
        this.id = id;
        this.url = url;
        this.expiresAt = expiresAt;
    }

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public boolean isExpired() {
        return expiresAt != null && LocalDateTime.now().isAfter(expiresAt);
    }

    public static UrlShort create(CreateShortUrlRequest request, String id) {
        UrlShort entity = new UrlShort();
        entity.setId(id);
        entity.setUrl(request.getUrl());
        entity.setExpiresAt(request.calculateExpiry());
        return entity;
    }

}