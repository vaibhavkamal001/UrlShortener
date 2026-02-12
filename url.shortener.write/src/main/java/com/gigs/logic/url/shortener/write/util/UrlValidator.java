package com.gigs.logic.url.shortener.write.util;

import java.util.regex.Pattern;

public class UrlValidator {

    private static final String URL_REGEX =
            "^(https?:\\/\\/)(www\\.)?([a-zA-Z0-9\\-]+\\.)+[a-zA-Z]{2,}(:\\d+)?(\\/[^\\s]*)?$";

    private static final Pattern PATTERN = Pattern.compile(URL_REGEX);

    public static boolean isValid(String url) {
        return url != null && PATTERN.matcher(url).matches();
    }
}