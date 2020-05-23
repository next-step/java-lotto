package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int FIRST_GROUP = 1;
    private static final int SECOND_GROUP = 2;

    private StringAddCalculator() {}

    public static StringAddCalculator create() {
        return new StringAddCalculator();
    }

    public int splitAndSum(String expression) {
        if(isNullOrEmpty(expression)) {
            return ZERO;
        }

        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(expression);
        if (m.find()) {
            return sumByCustomDelimiter(m);
        }

        String[] values = expression.split(DELIMITER);
        if(values.length == ONE) {
            return Integer.parseInt(values[0]);
        }

        return sum(values);
    }

    private int sumByCustomDelimiter(Matcher m) {
        String customDelimiter = m.group(FIRST_GROUP);
        String[] values = m.group(SECOND_GROUP).split(customDelimiter);

        return sum(values);
    }

    private boolean isNullOrEmpty(String expression) {
        return expression == null || expression.isEmpty();
    }

    private static int sum(String[] values) {
        return Arrays.stream(values)
            .mapToInt(StringAddCalculator::convertToInt)
            .sum();
    }

    private static int convertToInt(String value) {
        if(Integer.parseInt(value) < ZERO){
            throw new RuntimeException();
        }

        return Integer.parseInt(value);
    }
}
