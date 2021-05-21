package calculator.domain;

import calculator.dto.CalculatorExpression;
import calculator.util.CalculatorExpressionFactory;

import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int DEFAULT_RESULT = 0;
    private static final String NPE_MESSAGE = "값이 null 이거나 비어 있습니다.";

    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");


    private StringAddCalculator() {

    }

    public static int calculate(String expression) {
        try {
            validate(expression);
        } catch (NullPointerException e) {
            return DEFAULT_RESULT;
        }

        CalculatorExpression calculatorExpression = CalculatorExpressionFactory.of(expression, pattern);

        String separator = calculatorExpression.getSeparator();
        String formula = calculatorExpression.getFormula();
        CalculatorNumbers calculatorNumbers = extractCalculateNumbers(separator, formula);

        return calculatorNumbers.sum();
    }

    private static void validate(String expression) {
        if(expression == null || expression.isEmpty()) {
            throw new NullPointerException(NPE_MESSAGE);
        }
    }

    private static CalculatorNumbers extractCalculateNumbers(String separator, String formula) {
        String[] splitResults = formula.split(separator);

        return CalculatorNumbers.from(splitResults);
    }
}
