package calculator.domain;

import util.ValidateUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitor {
    private static final String VALID_EMPTY_INPUT_MESSAGE = "입력 값이 없습니다.";
    private static final String SPLIT_SEPARATOR = ",|:";
    private static final String CUSTOM_MATCHER = "//(.)\n(.*)";
    private static final int CUSTOM_SEPARATOR_INDEX = 1;
    private static final int CUSTOM_TARGET_INDEX = 2;

    private String input;

    public StringSplitor(String input) {
        validateStringSplitor(input);
        this.input = input;
    }

    private void validateStringSplitor(String input) {
        if (ValidateUtils.isEmpty(input)) {
            throw new IllegalArgumentException(VALID_EMPTY_INPUT_MESSAGE);
        }
    }

    public String[] splitSeparator() {
        Matcher m = Pattern.compile(CUSTOM_MATCHER).matcher(this.input);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_SEPARATOR_INDEX);
            return m.group(CUSTOM_TARGET_INDEX).split(customDelimiter);
        }

        return this.input.split(SPLIT_SEPARATOR);
    }

}
