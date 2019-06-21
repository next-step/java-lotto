package com.jaeyeonling.calculate.utils;

public class StringUtils {

    public static final String NEW_LINE = "\n";
    
    private StringUtils() { }

    public static boolean isNullOrBlank(final String source) {
        return source == null || source.isBlank();
    }
}
