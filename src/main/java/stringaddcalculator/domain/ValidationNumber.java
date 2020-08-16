package stringaddcalculator.domain;

public class ValidationNumber {

    private static final String NUMERICAL_REGULAR_EXPRESSION = "^[0-9]+$]";

    public static boolean isBlank(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static void negativeQuantity(int number) {
        if (number < StringAddCalculator.ZERO_NUMBER) {
            throw new RuntimeException();
        }
    }

    public static void invalidInput(String expression) {
        if (!expression.matches(NUMERICAL_REGULAR_EXPRESSION)) {
            throw new RuntimeException();
        }
    }
}
