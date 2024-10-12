package calculator;

import java.util.function.IntBinaryOperator;

public class StringCalculator {

    public static final String DELIMITER = " ";

    public int calculate(String input) {
        return calculateExpression(splitString(validInput(input)));
    }

    public String validInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("null 혹은 공백 문자열은 연산 불가능합니다");
        }
        return input;
    }

    public String[] splitString(String input) {
        return input.split(DELIMITER);
    }

    public int calculateExpression(String[] expression) {
        int result = Integer.parseInt(expression[0]);

        for (int i = 1; i < expression.length - 1; i += 2) {
            int operand = Integer.parseInt(expression[i + 1]);
            IntBinaryOperator operator = OperatorUtils.selection(expression[i]);
            result = operator.applyAsInt(result, operand);
        }
        return result;
    }

}
