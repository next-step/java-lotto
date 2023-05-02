package calculator;

import java.util.Stack;

public class Calculator {
    private static final Stack<String> stack = new Stack<>();
    public static final String INPUT_SPLITTING_REGEX = " ";
    public static final String ERROR_MESSAGE_ON_INVALID_INPUT = "입력값이 없습니다.";
    public static final String NUMEIRC_REGEX = "\\d+";
    public static final String OPERATOR_REGEX = "[+\\-*/]";

    public static int calculate(String input) {
        checkNotEmpty(input);
        for (String token : input.split(INPUT_SPLITTING_REGEX)) {
            handleNumberToken(token);
            handleOperatorToken(token);
        }
        return Integer.parseInt(stack.pop());
    }

    private static void checkNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ON_INVALID_INPUT);
        }
    }


    public static int operate(String notation, int left, int right) {
        Operator operator = Operator.fromNotation(notation);
        return operator.action.apply(left, right);
    }

    private static void handleNumberToken(String token) {
        if (!token.matches(NUMEIRC_REGEX)) {
            return;
        }
        if (stack.isEmpty()) {
            stack.push(token);
            return;
        }
        pushToStackWithOperation(token);
    }

    private static void pushToStackWithOperation(String token) {
        String operator = stack.pop();
        int left = Integer.parseInt(stack.pop());
        int right = Integer.parseInt(token);
        int result = operate(operator, left, right);
        stack.push(String.valueOf(result));
    }

    private static void handleOperatorToken(String token) {
        if (token.matches(OPERATOR_REGEX)) {
            stack.push(token);
        }
    }
}
