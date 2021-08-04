package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorParser {

    private final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private final String DEFAULT_SEPARATOR_REGEX = ",|:";
    private final int SEPARATOR_GROUP_NUMBER = 1;
    private final int EXPRESSION_GROUP_NUMBER = 2;

    private String separator;
    private String expression;

    public CalculatorParser(String input) {

        separator = DEFAULT_SEPARATOR_REGEX;
        expression = input;

        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (isCustomExpression(matcher)) {
            setCustomExpression(matcher);
        }
    }

    private boolean isCustomExpression(Matcher matcher) {
        return matcher.find();
    }

    private void setCustomExpression(Matcher matcher) {
        separator = matcher.group(SEPARATOR_GROUP_NUMBER);
        expression = matcher.group(EXPRESSION_GROUP_NUMBER);
    }

    public String[] split() {
        return expression.split(separator);
    }
}
