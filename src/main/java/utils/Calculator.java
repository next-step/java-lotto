package utils;

public class Calculator {

    public static int calculate(int number1, int number2, String operator) {
        if (operator.equals("+")) {
            return sum(number1, number2);
        }
        return 0;
    }

    public static int sum(int number1, int number2) {
        return number1 + number2;
    }
}
