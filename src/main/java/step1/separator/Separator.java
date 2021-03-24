package step1.separator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Separator {
    private final String expression;
    private final String CUSTOM_EXPRESSION_DELIMITER_FORMAT = "//(.)\n(.*)";
    private final String COMMA = ",";
    private final String COLON = ":";
    private final String BAR = "|";

    private final int DELIMITER_POSITION = 1;
    private final int EXPRESSION_POSITION = 2;

    public Separator(String expression) {
        this.expression = expression;
    }

    public final String[] splitByDelimiter(){
        Matcher m = Pattern.compile(CUSTOM_EXPRESSION_DELIMITER_FORMAT).matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(DELIMITER_POSITION);
            return m.group(EXPRESSION_POSITION).split(customDelimiter(customDelimiter));
        }
        return expression.split(defaultDelimiter());
    }

    private final String customDelimiter(String customDelimiter) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append(customDelimiter)
                .append(BAR)
                .append(defaultDelimiter())
                .toString();
    }

    private final String defaultDelimiter() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append(COMMA)
                .append(BAR)
                .append(COLON)
                .toString();
    }

}
