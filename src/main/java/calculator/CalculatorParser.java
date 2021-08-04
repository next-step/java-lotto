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

    public CalculatorParser(String s) {
        if (!isCustomExpression(s)) {
            separator = DEFAULT_SEPARATOR_REGEX;
            expression = s;
        }
    }

    private boolean isCustomExpression(String s) {
        Matcher matcher = CUSTOM_PATTERN.matcher(s);
        if (matcher.find()) {
            setCustomExpression(matcher);
            return true;
        }
        return false;
    }

    private void setCustomExpression(Matcher matcher) {
        separator = matcher.group(SEPARATOR_GROUP_NUMBER);
        expression = matcher.group(EXPRESSION_GROUP_NUMBER);
    }

    public String[] split() {
        return expression.split(separator);
    }
}
