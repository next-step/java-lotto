package calculator;

public class Calculator {

    public Calculator() {
    }

    public static int calculate(String value) {
        String[] tokens = value.trim().split(" ");
        int result = StringToInt(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int number = StringToInt(tokens[i + 1]);
            result = calculate(operator, result, number);
        }
        return result;
    }

    private static int calculate(String operator, int result, int number) {

        if (!(operator.contains("+") || operator.contains("-") || operator.contains("*") || operator.contains("/"))) {
            throw new IllegalArgumentException();
        }

        if (operator.equals("+")) {
            result += number;
        }
        if (operator.equals("-")) {
            result -= number;
        }
        if (operator.equals("*")) {
            result *= number;
        }
        if (operator.equals("/")) {
            result /= number;
        }
        return result;
    }

    public int add(int first, int second) {
        return first + second;
    }

    public int subtract(int first, int second) {
        return first - second;
    }

    public int multiply(int first, int second) {
        return first * second;
    }

    public int division(int first, int second) {
        validate(first, second);
        return first / second;
    }

    private static void validate(int first, int second) {
        if (first % second != 0) {
            throw new IllegalArgumentException();
        }
    }

    private static int StringToInt(String token) {
        return Integer.parseInt(token);
    }
}
