package domain;

import java.util.List;

public class Calculator {

    public static int operate(List<String> numbers, List<String> signs) {
        int result = calculate(
                signs.get(0),
                Integer.parseInt(numbers.get(0)),
                Integer.parseInt(numbers.get(1)));

        for (int i = 1; i < signs.size(); i++) {
            result = calculate(
                    signs.get(i),
                    result,
                    Integer.parseInt(numbers.get(i+1)));
        }
        return result;
    }

    public static int calculate(String symbol, int num1, int num2) {
        if ("+".equals(symbol)) {
            return plus(num1, num2);
        }
        if ("-".equals(symbol)) {
            return minus(num1, num2);
        }
        if ("*".equals(symbol)) {
            return multiply(num1, num2);
        }
        return divide(num1, num2);
    }

    public static int plus(int num1, int num2) {
        return num1 + num2;
    }

    public static int minus(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public static int divide(int num1, int num2) {
        return (int) (num1 / num2);
    }
}
