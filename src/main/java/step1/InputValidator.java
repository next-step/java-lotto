package step1;

public class InputValidator {
    private InputValidator() {
    }

    public static void isNotOrEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input is null or empty.");
        }
    }

    public static void nonArithmeticOperator(String input) {
        if (isOperation(input) == false && isNumber(input) == false) {
            throw new IllegalArgumentException("Input is nonArithmeticOperator.");
        }
    }

    public static boolean isOperation(String token) {
        return token.matches("[+\\-*/]");
    }

    public static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
