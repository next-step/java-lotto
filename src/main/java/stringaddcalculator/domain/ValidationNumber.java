package stringaddcalculator.domain;

public class ValidationNumber {

    public static boolean isBlank(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static void negativeQuantity(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }
}
