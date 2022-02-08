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

    private final String text;

    public DelimiterTokenizer(String text) {
        this.text = text;
    }

    public List<String> parseDelimiters() {
        final List<String> delimiters = new ArrayList<>(Arrays.asList(COMMA, COLON));
        if (isCustomDelimiter()) {
            String customDelimiter = this.text.substring(
                CUSTOM_DELIMITER_START_INDEX,
                getCustomDelimiterEndIndex());
            validateCustomDelimiter(customDelimiter);
            delimiters.add(customDelimiter);
        }
        return delimiters;
    }

    private boolean isCustomDelimiter() {
        return this.text.startsWith(DOUBLE_SLASH);
    }

    private int getCustomDelimiterEndIndex() {
        return this.text.indexOf(NEW_LINE);
    }

    private void validateCustomDelimiter(String customDelimiter) {
        validateNumberValue(customDelimiter);
        validateOverLengthValue(customDelimiter);
        validateNullValue(customDelimiter);
        validateNewLineValue(customDelimiter);
    }

    private void validateNumberValue(String customDelimiter) {
        try {
            Integer.parseInt(customDelimiter);
            throw new IllegalArgumentException("커스텀 구분자를 숫자를 사용할 수 없습니다.");
        } catch (NumberFormatException e) {
            return;
        }
    }

    private void validateOverLengthValue(String customDelimiter) {
        if (customDelimiter.length() > CUSTOM_DELIMITER_LENGTH_LIMIT) {
            throw new IllegalArgumentException("커스텀 구분자의 길이가 1을 초과할 수 없습니다.");
        }
    }

    private void validateNullValue(String customDelimiter) {
        if (customDelimiter.isEmpty() && (getCustomDelimiterEndIndex() == this.text.lastIndexOf(
            NEW_LINE))) {
            throw new IllegalArgumentException("커스텀 구분자를 빈 값으로 사용할 수 없습니다.");
        }
    }

    private void validateNewLineValue(String customDelimiter) {
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException("'\\n'를 구분자로 사용할 수 없습니다.");
        }
    }
}
