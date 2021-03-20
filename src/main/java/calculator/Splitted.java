package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitted {

    private static final String DELIMITER_REGEX = ",| |:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private final Expression expression;

    public Splitted(Expression expression) {
        this.expression = expression;
    }

    public String[] expression() {
        return split();
    }

    private String[] split() {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(expression.toString());
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter + "|" + DELIMITER_REGEX);
        }

        return expression.toString().split(DELIMITER_REGEX);
    }
}
