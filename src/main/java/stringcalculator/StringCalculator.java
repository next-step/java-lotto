package stringcalculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private static final String DEFAULT_VALUE = "0";
    private static final String DELIMITER = ",|:";

    private static final int DEFAULT_NUMBER = 0;
    private static final int FIRST_MATCHED = 1;
    private static final int SECOND_MATCHED = 2;

    public int calculate(String expression) {
        if (isNullAndEmpty(expression)) {
            return toInt(new Number(DEFAULT_NUMBER));
        }
        return toInt(toNumber(tokenize(expression)));
    }

    private int toInt(Number result) {
        return result.getNumber();
    }

    private Number toNumber(String[] tokens) {
        Number result = new Number(DEFAULT_VALUE);

        for (String token : tokens) {
            Number number = new Number(token);
            result = result.add(number);
        }
        return result;
    }

    private String[] tokenize(String expression) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(FIRST_MATCHED);
            return m.group(SECOND_MATCHED).split(customDelimiter);
        }
        return expression.split(DELIMITER);
    }

    private boolean isNullAndEmpty(String expression) {
        return Objects.isNull(expression) || expression.trim().isEmpty();
    }
}
