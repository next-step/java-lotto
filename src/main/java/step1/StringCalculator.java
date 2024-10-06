package step1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StringCalculator {

    private static final Queue<Integer> numbers = new LinkedList<>();
    private static final Queue<String> operators = new LinkedList<>();

    public static int run(String input) {
        if (!hasText(input)) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
        String[] splitValues = split(input);
        validate(splitValues);
        separateArray(splitValues);
        return calculate();
    }

    private static boolean hasText(String input) {
        return input != null && !input.isEmpty();
    }

    private static String[] split(String input) {
        return input.split(" ");
    }

    private static void validate(String[] splitValues) {
        Arrays.stream(splitValues).forEach(value -> {
            if (!isOperator(value) && !value.matches("^[0-9]*$")) {
                throw new IllegalArgumentException("숫자 또는 연산자가 아닌 값이 포함되어 있습니다.");
            }
        });
    }

    private static boolean isOperator(String operator) {
        return List.of("+", "-", "*", "/").contains(operator);
    }

    private static void separateArray(String[] splitValues) {
        for (String value : splitValues) {
            constructObject(value);
        }
    }

    private static void constructObject(String value) {
        if(isOperator(value)) {
            operators.add(value);
            return;
        }
        numbers.add(Integer.parseInt(value));
    }

    private static int calculate() {
        int result = numbers.poll();
        while (!operators.isEmpty()) {
            String operator = operators.poll();
            int number = numbers.poll();
            result = operate(result, number, operator);
        }

        return result;
    }

    private static int operate(int x, int y, String operator) {
        switch (operator) {
            case "+":
                return add(x, y);
            case "-":
                return subtract(x, y);
            case "*":
                return multiply(x, y);
            case "/":
                return divide(x, y);
            default:
                throw new IllegalArgumentException("올바른 연산자가 아닙니다.");
        }
    }

    private static int add(int x, int y) {
        return x + y;
    }

    private static int subtract(int x, int y) {
        return x - y;
    }

    private static int multiply(int x, int y) {
        return x * y;
    }

    private static int divide(int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return x / y;
    }
}
