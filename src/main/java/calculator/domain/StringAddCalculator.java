package calculator.domain;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private static final String EXPRESSION_DEFAULT_SEPARATOR = ",|:";
    private static final int DEFAULT_NUMBER = 0;

    private static final String CUSTOM_SEPARATOR_FIND_EXPRESSION = "//(.)\n(.*)";
    private static final Pattern CUSTOM_SEPARATOR_FIND_EXPRESSION_PATTERN = Pattern.compile(CUSTOM_SEPARATOR_FIND_EXPRESSION);
    private static final int CUSTOM_SEPARATOR_INDEX = 1;
    private static final int CUSTOM_FORMULA_INDEX = 2;

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
        Matcher customSeparatorFindMatcher = CUSTOM_SEPARATOR_FIND_EXPRESSION_PATTERN.matcher(expression);

        if (customSeparatorFindMatcher.find()) {
            String customDelimiter = customSeparatorFindMatcher.group(CUSTOM_SEPARATOR_INDEX);
            String formula = customSeparatorFindMatcher.group(CUSTOM_FORMULA_INDEX);

            return new CalculatorExpression(customDelimiter, formula);
        }

        return new CalculatorExpression(EXPRESSION_DEFAULT_SEPARATOR, expression);
    }
}
