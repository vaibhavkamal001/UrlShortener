package com.gigs.logic.url.shortener.write.util;


import java.util.UUID;

public class ShortIdGenerator {

    public static String generate() {
        return UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 8);
    }
}