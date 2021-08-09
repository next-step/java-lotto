package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAdditionCalculator {
    private static final String DEFAULT_DELIMITER_PATTERN = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final Pattern pattern = Pattern.compile("\\d+");

    private String extractExpression(String expression, Matcher matcher, final List<String> customDelimiterList) {
        while (matcher.find()) {
            String customDelimiter = matcher.group(1);
            customDelimiterList.add(customDelimiter);
            expression = expression.substring(matcher.start(2));
            matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(expression);
        }
        return expression;
    }

    private boolean isNullOrEmpty(String expression) {
        return Objects.isNull(expression) || "".equals(expression);
    }

    private boolean isNaturalNumber(String expression) {
        return pattern.matcher(expression).matches();
    }

    private PositiveNumbers splitWithCustomDelimiter(String expression) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(expression);

        List<String> customDelimiterList = new ArrayList<>();
        expression = extractExpression(expression, matcher, customDelimiterList);

        String delimiters = DEFAULT_DELIMITER_PATTERN;
        if (customDelimiterList.size() > 0) {
            delimiters = String.join("|", customDelimiterList);
        }
        return new PositiveNumbers(
            Stream.of(expression.split(delimiters))
                .mapToInt(Integer::parseInt)
                .toArray());
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
