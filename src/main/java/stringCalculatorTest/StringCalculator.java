package stringCalculatorTest;

import java.util.List;

public class StringCalculator {
    private static final List<String> OPERATION_SYMBOL = List.of("+", "-", "*", "/");

    public static int addition(int value1, int value2) {
        return value1 + value2;
    }

    public static int subtract(int value1, int value2) {
        return value1 - value2;
    }

    public static int division(int value1, int value2) {
        return value1 / value2;
    }

    public static int multiple(int value1, int value2) {
        return value1 * value2;
    }

    public static int calculation(String input) {
        checkBlank(input);

        List<String> tokens = List.of(input.split(" "));
        ckeckOperations(tokens);

        return calculate(tokens);
    }

    private static int calculate(List<String> tokens) {
        int result = Integer.parseInt(tokens.get(0));

        for (int i = 1; i < tokens.size(); i += 2) {
            if (tokens.get(i).equals("+")) {
                result = addition(result, Integer.parseInt(tokens.get(i + 1)));
            }

            if (tokens.get(i).equals("-")) {
                result = subtract(result, Integer.parseInt(tokens.get(i + 1)));
            }

            if (tokens.get(i).equals("/")) {
                result = division(result, Integer.parseInt(tokens.get(i + 1)));
            }

            if (tokens.get(i).equals("*")) {
                result = multiple(result, Integer.parseInt(tokens.get(i + 1)));
            }
        }
        return result;
    }

    private static void checkBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("input value is blank");
        }
    }

    private static void ckeckOperations(List<String> tokens) {
        for (int i = 1; i < tokens.size(); i += 2) {
            ckeckOpertaion(tokens.get(i));
        }
    }

    private static void ckeckOpertaion(String token) {
        if (!OPERATION_SYMBOL.contains(token)) {
            throw new IllegalArgumentException("input value is invalid operation symbol");
        }
    }
}
