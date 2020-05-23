package stringcalculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExpressionConverter {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int PURE_EXPRESSION_INDEX = 2;

    private StringExpressionConverter() {
    }

    public static List<String> convert(final String expression) {
        String pureExpression = expression.trim();
        Matcher customDelimiterMather = CUSTOM_DELIMITER_PATTERN.matcher(pureExpression);

        if (customDelimiterMather.find()) {
            String customDelimiter = customDelimiterMather.group(CUSTOM_DELIMITER_INDEX);
            return Arrays.asList(customDelimiterMather.group(PURE_EXPRESSION_INDEX).split(customDelimiter));
        }

        return Arrays.asList(pureExpression.split(BasicDelimiter.convertToRegex()));
    }

}
