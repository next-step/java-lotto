package com.seok2.common.utils;

public class StringUtils {

    public static boolean isBlank(String str) {
        if (str == null || str.trim().length() == 0) {
            return true;
        }
        return false;
    }

}
