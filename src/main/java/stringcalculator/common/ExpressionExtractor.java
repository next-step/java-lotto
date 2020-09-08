package stringcalculator.common;

import stringcalculator.expression.Delimiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionExtractor {
    private static final String EXPRESSION_PATTERN = "//(.)\\\\n(.*)";
    private static final int DELIMITER_GROUP = 1;
    private static final int NUMBERS_GROUP= 2;
    private static final Pattern pattern = Pattern.compile(EXPRESSION_PATTERN);

    private ExpressionExtractor() {
    }

    public static Delimiter extractDelimiter(String expression) {
        Matcher matcher = getMatcher(expression);
        if (matcher.find()) {
            return Delimiter.newInstance(matcher.group(DELIMITER_GROUP));
        }

        return Delimiter.newInstance();
    }

    public static String extractNumbers(String expression) {
        Matcher matcher = getMatcher(expression);
        if (matcher.find()) {
            return matcher.group(NUMBERS_GROUP);
        }

        return expression;
    }

    private static Matcher getMatcher(String expression) {
        return pattern.matcher(expression);
    }
}
