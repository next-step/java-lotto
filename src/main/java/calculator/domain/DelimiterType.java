package calculator.domain;

import java.util.regex.Pattern;

enum DelimiterType {
    CUSTOM("//(.)\n(.*)"),
    DEFAULT(",|:");

    private final String regex;

    DelimiterType(String regex) {
        this.regex = regex;
    }

    static DelimiterType findByExpression(String expression) {
        if (Pattern.compile(CUSTOM.regex).matcher(expression).find()) {
            return CUSTOM;
        }
        return DEFAULT;
    }

    String getRegex() {
        return regex;
    }
}
