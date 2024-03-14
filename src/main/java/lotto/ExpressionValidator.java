package lotto;

public class ExpressionValidator {

    public static void validateInputExpression(String inputString) {
        if (isEmptyExpression(inputString)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isEmptyExpression(String inputString) {
        return inputString == null || inputString.isEmpty();
    }
}
