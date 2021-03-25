package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    private StringUtils() {}

    public static boolean isEmpty(String value) {
        return (value == null || "".equals(value.trim()));
    }

    public static List<String> split(String value, String tokenizer) {
        return Arrays.asList(value.split(tokenizer));
    }

    public static int toInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("숫자 형태의 문자로 입력해주세요");
        }
    }
}
