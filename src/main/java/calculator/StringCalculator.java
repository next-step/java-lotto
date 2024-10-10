package calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringCalculator {

    private static final int CALCULATION_IMPOSSIBLE_SIZE = 1;
    private static final String DEFAULT_DELIMETER = " ";

    private StringCalculator() {
    }

    public static int splitAndCalculate(String expression) {
        if (isBlankOrNull(expression)) {
            throw new IllegalArgumentException("입력값이 null 또는 빈 공백 문자입니다.");
        }

        return calculate(createExpressionDeque(expression));
    }

    private static boolean isBlankOrNull(String expression) {
        return expression == null || expression.isEmpty();
    }

    private static Deque<String> createExpressionDeque(String expression) {
        Deque<String> deque = new ArrayDeque<>();
        for (String item : expression.split(DEFAULT_DELIMETER)) {
            validateInputValue(item);
            deque.offer(item);
        }
        return deque;
    }

    private static void validateInputValue(String input) {
        if (isNumber(input)) {
            return;
        }

        if (ArithmeticOperator.isValidOperator(input)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닌 문자는 허용되지 않습니다.");
        }
    }

    private static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static int calculate(Deque<String> expressionDeque) {
        while (expressionDeque.size() != CALCULATION_IMPOSSIBLE_SIZE) {
            String operand1 = expressionDeque.poll();
            String operator = expressionDeque.poll();
            String operand2 = expressionDeque.poll();
            expressionDeque.offerFirst(ArithmeticOperator.calculate(operand1, operator, operand2));
        }
        return Integer.parseInt(expressionDeque.pop());
    }
}
