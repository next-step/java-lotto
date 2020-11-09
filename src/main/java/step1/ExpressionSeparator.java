package step1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExpressionSeparator {
    private static final String COMMA_DELIMITER = ",";
    private static final String COLON_DELIMITER = ":";
    private static final String DEFAULT_DELIMITER = COLON_DELIMITER + "|" + COMMA_DELIMITER;

    private ExpressionSeparator() {
        throw new AssertionError();
    }

    public static List<String> split(final Expression expression, final String delimiter) {
        final List<String> result = Arrays.asList(expression.getText().split(delimiter));
        return Collections.unmodifiableList(result);
    }

    public static List<String> split(final Expression expression) {
        return split(expression, DEFAULT_DELIMITER);
    }
}
