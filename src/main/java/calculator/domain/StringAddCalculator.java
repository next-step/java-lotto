package calculator.domain;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private static String EXPRESSION_DEFAULT_SEPARATOR = ",|:";

    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }

        CalculatorExpression calculatorExpression = getCalculatorExpression(expression);

        String separator = calculatorExpression.getSeparator();
        String formula = calculatorExpression.getFormula();

        String[] split = formula.split(separator);

        CalculatorNumbers calculatorNumbers = new CalculatorNumbers(Arrays.stream(split)
                .map(CalculatorNumber::new)
                .collect(Collectors.toList()));

        return calculatorNumbers.sum();
    }

    private static CalculatorExpression getCalculatorExpression(String expression) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String formula = m.group(2);

            return new CalculatorExpression(customDelimiter, formula);
        }

        return new CalculatorExpression(EXPRESSION_DEFAULT_SEPARATOR, expression);
    }
}
