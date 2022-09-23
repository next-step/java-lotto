package calculator;

import java.util.Queue;

public class StringCalculator {
    public static final String DEFAULT_OPERATOR = "+";
    public static final String DEFAULT_DELIMITER = " ";

    private final Tokenizer tokenizer = new Tokenizer(DEFAULT_DELIMITER);

    public int calculate(String input) {
        Queue<String> tokens = tokenizer.queue(input);
        return calculate(tokens, DEFAULT_OPERATOR, 0);
    }

    private int calculate(Queue<String> tokens, String operator, int result) {
        if (tokens.isEmpty()) {
            return result;
        }

        String token = tokens.remove();
        try {
            int number = Integer.parseInt(token);
            result = operate(operator, result, number);
        } catch (NumberFormatException e) {
            return calculate(tokens, token, result);
        }

        return calculate(tokens, token, result);
    }

    private int operate(String operator, int num1, int num2) {
        if (operator.equals("+")) {
            return add(num1, num2);
        }

        if (operator.equals("-")) {
            return subtract(num1, num2);
        }

        if (operator.equals("*")) {
            return multiply(num1, num2);
        }

        if (operator.equals("/")) {
            return divide(num1, num2);
        }

        throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }

        return num1 / num2;
    }
}
