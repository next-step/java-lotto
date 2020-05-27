package stringAddCalculate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExpression {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private final String[] numbers;

    public StringExpression(final String expression) {
        this.numbers = spliter(expression);
    }

    private String[] spliter(final String expression) {

        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return expression.split(DEFAULT_DELIMITER);
    }

    public String[] getNumbers() {
        return numbers;
    }
}
