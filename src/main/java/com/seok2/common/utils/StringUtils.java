package com.seok2.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern DEFAULT_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DELIMITER_INDEX = 1;
    private static final int CONTENT_INDEX = 2;

    private StringUtils() {
    }

    public static String[] split(String str) {
        Matcher m = DEFAULT_PATTERN.matcher(str);
        if (m.find()) {
            String delimiter = m.group(DELIMITER_INDEX);
            return m.group(CONTENT_INDEX).split(delimiter);
        }
        return split(str, DEFAULT_DELIMITER);
    }

    public static String[] split(String str, String regex) {
        return str.split(regex);
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

}
