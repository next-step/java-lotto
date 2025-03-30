package com.nextstep.camp.common.utils;


import com.nextstep.camp.common.exception.UtilInstantiationException;

import java.math.BigDecimal;

public class NumberUtils {

    private static final int ZERO = 0;

    private NumberUtils() {
        throw new UtilInstantiationException();
    }

    public static boolean isNumber(String value) {
        if (StringUtils.hasNotText(value)) {
            return false;
        }
        return value.chars()
            .allMatch(Character::isDigit);
    }

    public static boolean isNotNumber(String value) {
        return !isNumber(value);
    }

    public static boolean isNegativeNumber(Number value) {
        if (value == null) {
            return false;
        }
        BigDecimal bigDecimal = new BigDecimal(value.toString());
        return bigDecimal.compareTo(BigDecimal.ZERO) < 0;
    }

    public static boolean isPositiveNumber(Number value) {
        if (value == null) {
            return false;
        }
        BigDecimal bigDecimal = new BigDecimal(value.toString());
        return bigDecimal.compareTo(BigDecimal.ZERO) > 0;
    }

    public static boolean isZero(Number value) {
        if (value == null) {
            return false;
        }
        BigDecimal bigDecimal = new BigDecimal(value.toString());
        return bigDecimal.compareTo(BigDecimal.ZERO) == ZERO;
    }


}
