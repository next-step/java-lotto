package calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private static final String DELIMITER = " ";

    public static List<String> split(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException(String.format("input text : [%s], 입력값에 null 이거나 빈 공백 문자는 올수없습니다.", text));
        }
        return Arrays.asList(text.split(DELIMITER));
    }

    public static boolean isValidOperator(String operator) {
        if ("+".equals(operator) || "-".equals(operator) || "*".equals(operator) || "/".equals(operator)) {
            return true;
        }
        throw new IllegalArgumentException(String.format("input operator : [%s], 사칙연산 기호만 올수 있습니다.", operator));
    }
}
