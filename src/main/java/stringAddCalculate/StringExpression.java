package stringAddCalculate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExpression {
    private String[] numbers;

    public StringExpression(final String expression) {
        this.numbers = spliter(expression);
    }

    private String[] spliter(String expression) {

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        if (expression.contains(":")) {
            return expression.split("[,:]");
        }

        if (expression.contains(",")) {
            return expression.split(",");
        }

        return null;
    }

    public String[] getNumbers() {
        return numbers;
    }
}
