package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DelimiterTokenizer {

    private static final int CUSTOM_DELIMITER_LENGTH_LIMIT = 1;
    private static final int CUSTOM_DELIMITER_START_INDEX = 2;
    private static final String DEFAULT_DELIMITER_COMMA = ",";
    private static final String DEFAULT_DELIMITER_COLON = ":";
    private static final String CUSTOM_DELIMITER_START_CHAR = "//";
    private static final String CUSTOM_DELIMITER_END_CHAR = "\n";

    private final String text;

    public DelimiterTokenizer(String text) {
        this.text = text;
    }

    public List<String> parseDelimiters() {
        final List<String> delimiters = new ArrayList<>(
            Arrays.asList(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON));
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
        return this.text.startsWith(CUSTOM_DELIMITER_START_CHAR);
    }

    private int getCustomDelimiterEndIndex() {
        return this.text.indexOf(CUSTOM_DELIMITER_END_CHAR);
    }

    private void validateCustomDelimiter(String customDelimiter) {
        validateNumberValue(customDelimiter);
        validateOverLengthValue(customDelimiter);
        validateNullValue(customDelimiter);
        validateNewLineValue(customDelimiter);
    }

    private void validateNumberValue(String customDelimiter) {
        if (isNumberString(customDelimiter)) {
            throw new IllegalArgumentException("커스텀 구분자를 숫자를 사용할 수 없습니다.");
        }
    }

    private boolean isNumberString(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void validateOverLengthValue(String customDelimiter) {
        if (customDelimiter.length() > CUSTOM_DELIMITER_LENGTH_LIMIT) {
            throw new IllegalArgumentException("커스텀 구분자의 길이가 1을 초과할 수 없습니다.");
        }
    }

    private void validateNullValue(String customDelimiter) {
        if (customDelimiter.isEmpty() && (getCustomDelimiterEndIndex() == this.text.lastIndexOf(
            CUSTOM_DELIMITER_END_CHAR))) {
            throw new IllegalArgumentException("커스텀 구분자를 빈 값으로 사용할 수 없습니다.");
        }
    }

    private void validateNewLineValue(String customDelimiter) {
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException("'\\n'를 구분자로 사용할 수 없습니다.");
        }
    }
}
