package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionSplitter {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DELIMITER_INDEX = 1;
    private static final int EXPRESSION_INDEX = 2;

    private ExpressionSplitter() {
    }

    public static List<String> split(String expression) {
        Matcher matcher = CUSTOM_PATTERN.matcher(expression);
        if (matcher.find()) {
            String customDelimiter = matcher.group(DELIMITER_INDEX);
            return Arrays.asList(matcher.group(EXPRESSION_INDEX).split(customDelimiter));
        }
        return Arrays.asList(expression.split(Delimiter.joinTypes()));
    }
}
