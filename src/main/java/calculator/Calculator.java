package calculator;

import java.util.Stack;

public class Calculator {
    private static final Stack<String> stack = new Stack<>();

    public static int calculate(String input) {
        checkNotEmpty(input);
        for (String token : input.split(" ")) {
            handleNumberToken(token);
            handleOperatorToken(token);
        }
        return Integer.parseInt(stack.pop());
    }

    private static void checkNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }


    public static String operate(String operator, int left, int right) {
        int result = 0;
        if (operator.equals("+")) {
            result = left + right;
        }
        if (operator.equals("-")) {
            result = left - right;
        }
        if (operator.equals("*")) {
            result = left * right;
        }
        if (operator.equals("/")) {
            result = left / right;
        }
        return String.valueOf(result);
    }

    private static void handleNumberToken(String token) {
        if (token.matches("\\d+") && stack.isEmpty()) {
            stack.push(token);
            return;
        }
        if (token.matches("\\d+")) {
            String operator = stack.pop();
            int left = Integer.parseInt(stack.pop());
            int right = Integer.parseInt(token);
            stack.push(operate(operator, left, right));
        }
    }

    private static void handleOperatorToken(String token) {
        if (token.matches("[+\\-*/]")) {
            stack.push(token);
        }
    }
}
