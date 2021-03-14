package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final String BASIC_DELIMITER_REGEX = "[,:]";

    private static final Pattern CUSTOM_DELIMITER_EXPRESSION_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int EXPRESSION_GROUP = 2;

    private Parser() {}

    public static Sequence generateSequence(String expression) {
        return new Sequence(splitExpression(expression));
    }

    private static List<String> splitExpression(String expression) {
        Matcher matcher = CUSTOM_DELIMITER_EXPRESSION_PATTERN.matcher(expression);

        return matcher.find()
                ? splitByDelimiterPattern(matcher.group(CUSTOM_DELIMITER_GROUP), matcher.group(EXPRESSION_GROUP))
                : splitByDelimiterPattern(BASIC_DELIMITER_REGEX, expression);
    }

    private static List<String> splitByDelimiterPattern(String pattern, String expression) {
        return Arrays.asList(expression.split(pattern));
    }
}
