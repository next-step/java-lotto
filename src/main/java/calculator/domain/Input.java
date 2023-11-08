package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {

    private static final String REGEX_NUMBER = "[0-9]";
    private static final String ARITHMETIC = "[+\\-*/]";
    private static final String BLANK = " ";
    private static final Pattern ARITHMETIC_PATTERN = Pattern.compile(ARITHMETIC);

    private final String text;

    public Input(String text) {
        validateEmptyOrNull(text);
        validateArithmetic(text);
        this.text = text;
    }

    public void validateEmptyOrNull(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자일 수 없습니다.");
        }
    }

    public void validateArithmetic(String text) {
        String operators = extractedOperator(text);
        for (char operator : operators.toCharArray()) {
            validateOperator(Character.toString(operator));
        }
    }

    private static String extractedOperator(String text) {
        return text.replaceAll(REGEX_NUMBER, "")
                .replaceAll(BLANK, "");
    }

    private void validateOperator(String operator) {
        Matcher matcher = ARITHMETIC_PATTERN.matcher(String.valueOf(operator));
        if (!matcher.find()) {
            throw new IllegalArgumentException("사칙연산 기호만 사용 가능합니다.");
        }
    }

}
