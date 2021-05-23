package step3.util;

import java.util.regex.Pattern;

public class StringUtils {
    private static final String ONLY_NUMBER = "숫자를 입력하세요";

    public static Integer parseInt(String number) {
        validation(number);
        return Integer.parseInt(number);
    }

    private static void validation(String number) {
        if (!Pattern.matches("^[0-9]+$", number)) {
            throw new IllegalArgumentException(ONLY_NUMBER);
        }
    }

}
