package calculator.domain;

import calculator.util.CalculatorExpressionFactory;
import calculator.util.CalculatorNumbersFactory;

import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int DEFAULT_RESULT = 0;

    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    private StringAddCalculator() {

    }

    public static int calculate(String expression) {
        if (validate(expression)) {
            return DEFAULT_RESULT;
        }
        CalculatorExpression calculatorExpression = CalculatorExpressionFactory.of(expression, pattern);

        String separator = calculatorExpression.getSeparator();
        String formula = calculatorExpression.getFormula();
        CalculatorNumbers calculatorNumbers = extractCalculateNumbers(separator, formula);

        return calculatorNumbers.sum();
    }

    private static boolean validate(String expression) {
        return expression == null || expression.isEmpty();
    }

    private static CalculatorNumbers extractCalculateNumbers(String separator, String formula) {
        String[] splitResults = formula.split(separator);

        return CalculatorNumbersFactory.from(splitResults);
    }
}
