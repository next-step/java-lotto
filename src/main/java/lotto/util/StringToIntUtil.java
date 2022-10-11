package lotto.util;

import java.util.regex.Pattern;

public class StringToIntUtil {

    private static final String INTEGER_REGEX = "-?\\d+";

    public static int apply(String str) {
        if (canInteger(str)) {
            return Integer.parseInt(str);
        }
        throw new IllegalArgumentException("정수로 변환할 수 없는 문자열입니다.");
    }

    private static boolean canInteger(String str) {
        return str != null && str.matches(INTEGER_REGEX);
    }
}
