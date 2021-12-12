package calculator.domain;

import java.util.regex.Pattern;

enum DelimiterType {
    CUSTOM("//(.)\n(.*)"),
    DEFAULT(",|:");

    private static final Pattern DELIMITER_CUSTOM_PATTERN = Pattern.compile(CUSTOM.regex);

    private final String regex;

    DelimiterType(String regex) {
        this.regex = regex;
    }

    static DelimiterType findByExpression(String expression) {
        if (DELIMITER_CUSTOM_PATTERN.matcher(expression).find()) {
            return CUSTOM;
        }
        return DEFAULT;
    }

    String getRegex() {
        return regex;
    }
}
