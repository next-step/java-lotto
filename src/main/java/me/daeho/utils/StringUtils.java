package me.daeho.utils;

public class StringUtils {
    private static final String BLANK = "";
    public static boolean isEmpty(String data) {
        return data == null || BLANK.equals(data.trim());
    }
}
