package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DelimiterTokenizer {

    private static final int CUSTOM_DELIMITER_LENGTH_LIMIT = 1;
    private static final int CUSTOM_DELIMITER_START_INDEX = 2;
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String NEW_LINE = "\n";
    private static final String DOUBLE_SLASH = "//";

    private DelimiterTokenizer() {
    }

    public static List<String> getDelimiters(String text) {
        final List<String> delimiters = new ArrayList<>(Arrays.asList(COMMA, COLON));
        if (isCustomDelimiter(text)) {
            String customDelimiter = text.substring(
                CUSTOM_DELIMITER_START_INDEX,
                getCustomDelimiterEndIndex(text));
            validateCustomDelimiter(customDelimiter, text);
            delimiters.add(customDelimiter);
        }
        return delimiters;
    }

    private static int getCustomDelimiterEndIndex(String text) {
        return text.indexOf(NEW_LINE);
    }

    private static void validateCustomDelimiter(String customDelimiter, String text) {
        validateNumberValue(customDelimiter);
        validateOverLengthValue(customDelimiter);
        validateNullValue(customDelimiter, text);
        validateNewLineValue(customDelimiter);
    }

    private static void validateNumberValue(String customDelimiter) {
        if(customDelimiter.matches("[0-9]*")) {
            throw new IllegalArgumentException("커스텀 구분자를 숫자를 사용할 수 없습니다.");
        }
    }

    private static void validateOverLengthValue(String customDelimiter) {
        if (customDelimiter.length() > CUSTOM_DELIMITER_LENGTH_LIMIT) {
            throw new IllegalArgumentException("커스텀 구분자의 길이가 1을 초과할 수 없습니다.");
        }
    }

    private static void validateNullValue(String customDelimiter, String text) {
        if (customDelimiter.isEmpty()
            && (getCustomDelimiterEndIndex(text) == text.lastIndexOf(NEW_LINE))) {
            throw new IllegalArgumentException("커스텀 구분자를 빈 값으로 사용할 수 없습니다.");
        }
    }

    private static void validateNewLineValue(String customDelimiter) {
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException("'\\n'를 구분자로 사용할 수 없습니다.");
        }
    }

    private static boolean isCustomDelimiter(String text) {
        return text.startsWith(DOUBLE_SLASH);
    }

}
