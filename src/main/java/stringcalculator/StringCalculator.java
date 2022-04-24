package stringcalculator;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringCalculator {
    private static final String NOT_ALLOW_NULL_OR_EMPTY_MESSAGE = "비거나 null값은 허용되지 않습니다.";
    private static final int FIRST_NUMBER_INDEX = 0;
    private static final int SECOND_NUMBER_INDEX = 2;
    private static final int FIRST_EXPRESSION_LENGTH = 3;
    private static final String ALLOW_LENGTH_EXCEED_MESSAGE = "허용된 길이를 초과했습니다.";
    private static final String STRING_SPLIT_DELIMITER = " ";
    private static final int SYMBOL_INDEX = 1;

    public int plus(String expression) {
        int firstNumber = getFirstNumber(expression);
        int secondNumber = getSecondNumber(expression);

        return firstNumber + secondNumber;
    }

    public int minus(String expression) {
        int firstNumber = getFirstNumber(expression);
        int secondNumber = getSecondNumber(expression);

        return firstNumber - secondNumber;
    }

    public int multiply(String expression) {
        int firstNumber = getFirstNumber(expression);
        int secondNumber = getSecondNumber(expression);

        return firstNumber * secondNumber;
    }

    public int division(String expression) {
        int firstNumber = getFirstNumber(expression);
        int secondNumber = getSecondNumber(expression);

        return firstNumber / secondNumber;
    }

    public int calculate(String expression) {
        checkEmpty(expression);

        expression = expression.trim();
        String[] expressionStrings = expression.split(STRING_SPLIT_DELIMITER);
        if (expressionStrings.length == SYMBOL_INDEX) {
            return Integer.parseInt(expression);
        }

        String symbol = expressionStrings[SYMBOL_INDEX];
        String firstExpression = getFirstExpression(expressionStrings);

        int firstExpressionResult = 0;
        if ("+".equals(symbol)) {
            firstExpressionResult = this.plus(firstExpression);
        }

        if ("-".equals(symbol)) {
            firstExpressionResult = this.minus(firstExpression);
        }

        if ("*".equals(symbol)) {
            firstExpressionResult = this.multiply(firstExpression);
        }

        if ("/".equals(symbol)) {
            firstExpressionResult = this.division(firstExpression);
        }

        String otherExpression = getOtherExpression(expressionStrings);

        return calculate(String.format("%s %s", firstExpressionResult, otherExpression));
    }

    private String getFirstExpression(String[] strings) {
        return Arrays.stream(strings)
                .limit(FIRST_EXPRESSION_LENGTH)
                .collect(Collectors.joining(STRING_SPLIT_DELIMITER));
    }

    private String getOtherExpression(String[] strings) {
        return Arrays.stream(strings)
                .skip(FIRST_EXPRESSION_LENGTH)
                .collect(Collectors.joining(STRING_SPLIT_DELIMITER));
    }

    private int getSecondNumber(String expression) {
        String[] strings = getStrings(expression);
        return toInt(strings[SECOND_NUMBER_INDEX]);
    }

    private int getFirstNumber(String expression) {
        String[] strings = getStrings(expression);
        return toInt(strings[FIRST_NUMBER_INDEX]);
    }

    private int toInt(String string) {
        return Integer.parseInt(string);
    }

    private String[] getStrings(String expression) {
        return expression.split(STRING_SPLIT_DELIMITER);
    }

    private void checkEmpty(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException(NOT_ALLOW_NULL_OR_EMPTY_MESSAGE);
        }
    }
}
