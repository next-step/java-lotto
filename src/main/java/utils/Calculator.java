package utils;

public class Calculator {

    public static int calculate(int number1, int number2, String operator) {
        if (operator.equals("+")) {
            return sum(number1, number2);
        }

        if (operator.equals("-")) {
            return subtract(number1, number2);
        }

        if (operator.equals("*")) {
            return multiply(number1, number2);
        }

        if (operator.equals("/")) {
            return divide(number1, number2);
        }
        return 0;
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
