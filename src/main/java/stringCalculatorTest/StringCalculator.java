package stringCalculatorTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class StringCalculator {
    private static final List<String> OPERATION_SYMBOL = List.of("+", "-", "*", "/");

    private static final String BLANK = " ";
    private static final String BLANK_INPUT_MESSAGE = "input value is blank";
    private static final String INVALID_OPERATOR_MESSAGE = "input value is invalid operation symbol";
    private static Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();

    static {
        operations.put("+", StringCalculator::addition);
        operations.put("-", StringCalculator::subtract);
        operations.put("*", StringCalculator::multiple);
        operations.put("/", StringCalculator::division);
    }

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

        List<String> tokens = List.of(input.split(BLANK));
        ckeckOperations(tokens);

        return calculate(tokens);
    }

    private static int calculate(List<String> tokens) {
        int result = Integer.parseInt(tokens.get(0));

        for (int i = 1; i < tokens.size(); i += 2) {
            String operator = tokens.get(i);
            int operand = Integer.parseInt(tokens.get(i + 1));
            result = operations.get(operator).apply(result, operand);
        }
        return result;
    }

    private static void checkBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(BLANK_INPUT_MESSAGE);
        }
    }

    private static void ckeckOperations(List<String> tokens) {
        for (int i = 1; i < tokens.size(); i += 2) {
            ckeckOpertaion(tokens.get(i));
        }
    }

    private static void ckeckOpertaion(String token) {
        if (!OPERATION_SYMBOL.contains(token)) {
            throw new IllegalArgumentException(INVALID_OPERATOR_MESSAGE);
        }
    }
}
