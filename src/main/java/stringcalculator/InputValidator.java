package stringcalculator;

public class InputValidator {
    public static void validateNumber(String token) {
        if (!isNumber(token)) {
            throw new IllegalArgumentException("Input is not a correct formula.");
        }
    }

    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void validateOperator(String token) {
        if (!isOperator(token)) {
            throw new IllegalArgumentException("Input is not a correct formula.");
        }
    }
    private static boolean isOperator(String token) {
        return token.matches("[+\\-*/]");
    }

    public static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input is null or empty.");
        }
    }
}
