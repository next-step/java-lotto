package com.seok2.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private static final String DEFAULT_DELIMITER = ",|:";

    public static String[] split(String str) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        if (m.find()) {
            String delimiter = m.group(1);
            return m.group(2).split(delimiter);
        }
        return split(str, DEFAULT_DELIMITER);
    }

    public static String[] split(String str, String regex) {
        return str.split(regex);
    }

    public static boolean isBlank(String str) {
        if (str == null || str.trim().length() == 0) {
            return true;
        }
        return false;
    }

}
