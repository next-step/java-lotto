package calculator;

import java.util.*;

public class StringCalculator {
    static Queue<Integer> numbers = new LinkedList<>();
    static Queue<String> operators = new LinkedList<>();

    public static int calculate(String input) {
        String[] tokens = Tokenizer.tokenize(input);
        makeQueueFromTokens(tokens);
        return proceedCalculate();
    }

    private static int proceedCalculate() {
        int result = numbers.poll();
        while (!operators.isEmpty()) {
            result = processOperator(result, operators.poll());
        }
        return result;
    }

    private static int processOperator(int result, String operator) {
        if (isAdder(operator)) {
            result = add(result, numbers.poll());
        }
        if (isSubtractor(operator)) {
            result = subtract(result, numbers.poll());
        }
        if (isMultiplyer(operator)) {
            result = multiply(result, numbers.poll());
        }
        if (isDivider(operator)) {
            result = divide(result, numbers.poll());
        }
        return result;
    }

    private static void makeQueueFromTokens(String[] tokens) {
        Arrays.stream(tokens).forEach(token -> seperateNumberAndOperator(token));
    }

    private static void seperateNumberAndOperator(String token) {
        if (isInteger(token)) {
            numbers.add(Integer.parseInt(token));
        }
        if (isOperator(token)) {
            operators.add(token);
        }
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        return a / b;
    }

    private static boolean isAdder(String token) {
        return token.equals("+");
    }

    private static boolean isSubtractor(String token) {
        return token.equals("-");
    }

    private static boolean isMultiplyer(String token) {
        return token.equals("*");
    }

    private static boolean isDivider(String token) {
        return token.equals("/");
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isOperator(String input) {
        return "+".equals(input) || "-".equals(input) || "*".equals(input) || "/".equals(input);
    }
}
