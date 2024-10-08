package calculator;

import java.util.Set;

import static calculator.ErrorMessage.*;

public class Calculator {
    private static final Set<String> OPERATION_SET = Set.of("+", "-", "*", "/");
    private static final String DELIMETER = " ";

    public static void validateString(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(BLINK_INPUT_ERROR);
        }
    }

    private static boolean isBlank(String input) {
        return (input == null || input.trim().isEmpty());
    }

    public static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
    }

    public static void validateOperationSymbol(String input) {
        if (!OPERATION_SET.contains(input)) {
            throw new IllegalArgumentException(INPUT_IS_NOT_OPERATOR_SYMBOL);
        }
    }

    public static int addNumbers(int num1, int num2) {
        return num1 + num2;
    }

    public static int subtractNumbers(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiplyNumbers(int num1, int num2) {
        return num1 * num2;
    }

    public static int divideNumbers(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException(DIVDE_ZERO_ERROR);
        }
        return num1 / num2;
    }

    public static String[] splitInput(String input) {
        return input.split(DELIMETER);
    }
}
