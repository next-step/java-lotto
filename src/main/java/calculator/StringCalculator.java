package calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringCalculator {

    private final static String OPERATORS = "+-*/";

    private StringCalculator() {
    }

    public static void splitAndCalculate(String expression) {
        if (isBlankOrNull(expression)) {
            throw new IllegalArgumentException("입력값이 null 또는 빈 공백 문자입니다.");
        }

        createExpressionStack(expression);
    }

    private static boolean isBlankOrNull(String expression) {
        return expression == null || expression.isEmpty();
    }

    private static Deque<String> createExpressionStack(String expression) {
        Deque<String> stack = new ArrayDeque<>();
        for (String item : expression.split(" ")) {
            validateInputValue(item);
            stack.push(item);
        }
        return stack;
    }

    private static void validateInputValue(String input) {
        if (!isValidNumber(input)) {
            throw new IllegalArgumentException("입력값에 음수가 포함되어 있습니다.");
        }

        if (!isValidOperator(input)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닌 문자는 허용되지 않습니다.");
        }
    }

    private static boolean isValidNumber(String number) {
        if (isNumber(number) && Integer.parseInt(number) < 0) {
            return false;
        }
        return true;
    }

    private static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isValidOperator(String input) {
        return OPERATORS.contains(input);
    }
}
