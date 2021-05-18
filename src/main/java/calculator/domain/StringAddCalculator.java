package calculator.domain;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private static String EXPRESSION_DEFAULT_SEPARATOR = ",|:";
    private static int DEFAULT_NUMBER = 0;
    private static String CUSTOM_SEPARATOR_FIND_EXPRESSION = "//(.)\n(.*)";
    private static int CUSTOM_SEPARATOR_INDEX = 1;
    private static int CUSTOM_FORMULA_INDEX = 2;

    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return DEFAULT_NUMBER;
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
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR_FIND_EXPRESSION).matcher(expression);

        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_SEPARATOR_INDEX);
            String formula = m.group(CUSTOM_FORMULA_INDEX);

            return new CalculatorExpression(customDelimiter, formula);
        }

        return new CalculatorExpression(EXPRESSION_DEFAULT_SEPARATOR, expression);
    }
}
