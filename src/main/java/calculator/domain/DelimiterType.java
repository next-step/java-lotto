package calculator.domain;

import java.util.regex.Pattern;

enum DelimiterType {
    CUSTOM("//(.)\n(.*)"),
    DEFAULT(",|:");

    public static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM.regex);

    private final String regex;

    DelimiterType(String regex) {
        this.regex = regex;
    }

    public static DelimiterType findByExpression(String expression) {
        if (CUSTOM_PATTERN.matcher(expression).find()) {
            return CUSTOM;
        }
        return DEFAULT;
    }

    public String getRegex() {
        return regex;
    }
}
