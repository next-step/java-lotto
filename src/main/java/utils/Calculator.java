package utils;

public class Calculator {
    private static final String PLUS_SYMBOL = "+";
    private static final String MINUS_SYMBOL = "-";
    private static final String MULTIPLY_SYMBOL = "*";
    private static final String DIVIDE_SYMBOL = "/";

    public static int calculate(int number1, int number2, String operator) {
        if (operator.equals(PLUS_SYMBOL)) {
            return sum(number1, number2);
        }

        if (operator.equals(MINUS_SYMBOL)) {
            return subtract(number1, number2);
        }

        if (operator.equals(MULTIPLY_SYMBOL)) {
            return multiply(number1, number2);
        }

        if (operator.equals(DIVIDE_SYMBOL)) {
            return divide(number1, number2);
        }

        throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
    }

    public static int sum(int number1, int number2) {
        return number1 + number2;
    }

    public static int subtract(int number1, int number2) {
        return number1 - number2;
    }

    public static int multiply(int number1, int number2) {
        return number1 * number2;
    }

    public static int divide(int number1, int number2) {
        return number1 / number2;
    }
}
