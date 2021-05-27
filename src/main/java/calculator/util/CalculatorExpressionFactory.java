package calculator.util;

import calculator.dto.CalculatorExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.format;

public class CalculatorExpressionFactory {
    public static final String STANDARD_SEPARATOR = ",|:";

    private static final String CUSTOMER_SEPARATOR_FORMAT = "%s|%s";
    private static final int SEPARATOR_INDEX = 1;
    private static final int FORMULA_INDEX = 2;

    private CalculatorExpressionFactory() {

    }

    public static CalculatorExpression of(String expression, Pattern pattern) {
        Matcher result = pattern.matcher(expression);
        if (result.find() == true) {
            String separator = format(CUSTOMER_SEPARATOR_FORMAT, STANDARD_SEPARATOR, result.group(SEPARATOR_INDEX));
            String formula = result.group(FORMULA_INDEX);
            return new CalculatorExpression(separator, formula);
        }
        return new CalculatorExpression(STANDARD_SEPARATOR, expression);
    }
}
