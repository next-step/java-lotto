package stringcalculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DELIMITER = ",|:";

    public int calculate(String expression) {
        if (isNullAndEmpty(expression)) {
            return 0;
        }
        String[] tokens = tokenize(expression);
        int sum = 0;
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException();
            }
            sum += number;
        }

        return sum;
    }

    private String[] tokenize(String expression) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return expression.split(DELIMITER);
    }

    private boolean isNullAndEmpty(String expression) {
        return Objects.isNull(expression) || expression.trim().isEmpty();
    }
}
