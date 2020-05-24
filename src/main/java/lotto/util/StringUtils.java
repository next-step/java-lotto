package lotto.util;

import lotto.exception.InputValueException;

public final class StringUtils {

    private StringUtils() {
    }

    public static int toInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new InputValueException("숫자로 변환할 수 없습니다. " + value);
        }
    }
}
