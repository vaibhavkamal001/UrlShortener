CREATE TABLE url_short (
    id VARCHAR(20) PRIMARY KEY,
    url TEXT NOT NULL,

    expires_at TIMESTAMP,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_url_short_expires_at ON url_short (expires_at);
CREATE INDEX idx_url_short_created_at ON url_short (created_at);