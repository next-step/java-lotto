package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionSplitter {
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";
    private static final int DELIMITER_INDEX = 1;
    private static final int EXPRESSION_INDEX = 2;

    private ExpressionSplitter() {
    }

    public static List<String> split(String expression) {
        Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(DELIMITER_INDEX);
            return Arrays.asList(m.group(EXPRESSION_INDEX).split(customDelimiter));
        }
        return Arrays.asList(expression.split(Delimiter.joinTypes()));
    }
}
