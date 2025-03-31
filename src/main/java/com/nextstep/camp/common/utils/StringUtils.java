package com.nextstep.camp.common.utils;


import com.nextstep.camp.common.exception.UtilInstantiationException;

public class StringUtils {

    private StringUtils() {
        throw new UtilInstantiationException();
    }

    public static boolean hasNotText(String value) {
        return value == null || value.isBlank();
    }

    public static boolean hasText(String value) {
        return !hasNotText(value);
    }
}
