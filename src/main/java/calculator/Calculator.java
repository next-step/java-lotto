package calculator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.format;

public class Calculator {

    public static final int DEFAULT_RESULT = 0;
    private static final String EMPTY_STRING = "";

    private static final String DELIMITERS = ",:";
    private static final String PRESTATED_DELIMITER_REGEX = "[" + DELIMITERS + "%s" + "]";
    public static final Pattern DEFAULT_DELIMITER_PATTERN = Pattern.compile(format(PRESTATED_DELIMITER_REGEX, EMPTY_STRING));

    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DELIMITER_GROUP = 1;
    private static final int EXPRESSION_GROUP = 2;

    private Calculator() {
    }

    public static int calculate(String expression) {
        if (isEmpty(expression)) {
            return DEFAULT_RESULT;
        }
        Numbers numbers = createNumbers(expression);
        return numbers.sum();
    }

    private static boolean isEmpty(String expression) {
        return expression == null || expression.equals(EMPTY_STRING);
    }

    private static Numbers createNumbers(String expression) {
        if (useCustomPattern(expression)) {
            return createNumbersWithCustomDelimiter(expression);
        }
        return Numbers.from(expression, DEFAULT_DELIMITER_PATTERN);
    }

    private static boolean useCustomPattern(String expression) {
        Matcher matcher = CUSTOM_PATTERN.matcher(expression);
        return matcher.matches();
    }

    private static Numbers createNumbersWithCustomDelimiter(String expression) {
        Matcher matcher = CUSTOM_PATTERN.matcher(expression);
        checkExistsGroup(matcher);

        String customDelimiter = matcher.group(DELIMITER_GROUP);
        String delimiterRegex = format(PRESTATED_DELIMITER_REGEX, customDelimiter);
        String realExpression = matcher.group(EXPRESSION_GROUP);
        return Numbers.from(realExpression, Pattern.compile(delimiterRegex));
    }

    private static void checkExistsGroup(Matcher matcher) {
        if (!matcher.find()) {
            throw new IllegalArgumentException("형식이 맞지 않습니다.");
        }
    }
}
