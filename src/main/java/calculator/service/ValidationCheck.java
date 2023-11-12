package calculator.service;

import java.util.regex.Pattern;

public class ValidationCheck {
    private static final String NUMBER_REG_EXP = ".*[^0-9].*";
    private static final String OPERATOR_REG_EXP = ".*[^+\\-*/].*";

    public static void checkInputString(String input) {
        if (isEmpty(input)) {
            throw new NullPointerException();
        }

        String[] tokens = input.split(" ");

        checkStringLength(tokens);

        for (int i = 0; i < tokens.length; i++) {
            validateOrder(tokens, i);
        }
    }

    private static boolean isEmpty(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }
        return false;
    }

    private static void checkStringLength(String[] inputTokens) {
        if (inputTokens.length % 2 == 0) {
            throw new IllegalArgumentException("사칙연산이 제대로 입력되지 않았습니다.");
        }
    }

    private static void validateOrder(String[] inputTokens, int inputOrder) {
        if (inputOrder % 2 == 0) {
            isNumber(inputTokens[inputOrder]);
        }
        if (inputOrder % 2 == 1) {
            isOperator(inputTokens[inputOrder]);
        }
    }

    private static void isNumber(String input) {
        if (Pattern.matches(NUMBER_REG_EXP, input)) {
            throw new IllegalArgumentException("홀수번째에는 숫자가 와야합니다.");
        }
    }

    private static void isOperator(String input) {
        if (Pattern.matches(OPERATOR_REG_EXP, input)) {
            throw new IllegalArgumentException("짝수번째에는 사칙연산자가 와야합니다.");
        }
    }
}
