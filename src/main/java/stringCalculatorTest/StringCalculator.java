package stringCalculatorTest;

import java.util.List;

public class StringCalculator {
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
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("input value is blank");
        }

        List<String> tokens = List.of(input.split(" "));

        for (int i = 1; i < tokens.size(); i += 2) {
            if (!(tokens.get(i).equals("+") || tokens.get(i).equals("-") || tokens.get(i).equals("/") || tokens.get(i).equals("*"))) {
                throw new IllegalArgumentException("input value is invalid operation symbol");
            }
        }

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
}
