package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionCalculator {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    private Tokens splitWithCustomDelimiter(String expression) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(expression);

        List<String> customDelimiterList = new ArrayList<>();
        expression = extractExpression(expression, matcher, customDelimiterList);

        String delimiters = ",|:";
        if (customDelimiterList.size() > 0) {
            delimiters = String.join("|", customDelimiterList);
        }
        return new Tokens(expression.split(delimiters));
    }

    private String extractExpression(String expression, Matcher matcher, final List<String> customDelimiterList) {
        while (matcher.find()) {
            String customDelimiter = matcher.group(1);
            customDelimiterList.add(customDelimiter);
            expression = expression.substring(matcher.start(2));
            matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(expression);
        }
        return expression;
    }

    private boolean isNaturalNumber(String expression) {
        Pattern pattern = Pattern.compile("\\d+");
        return pattern.matcher(expression).matches();
    }

    private boolean isNullOrEmpty(String expression) {
        return Objects.isNull(expression) || "".equals(expression);
    }

    public int splitAndSum(String expression) {
        if (isNullOrEmpty(expression)) {
            return 0;
        }

        if (isNaturalNumber(expression)) {
            return Integer.parseInt(expression);
        }

        return splitWithCustomDelimiter(expression).sum();
    }
}
