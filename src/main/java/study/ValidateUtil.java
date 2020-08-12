package study;

public class ValidateUtil {

    private ValidateUtil() {
    }

    public static boolean validateEmptyExpression(String expression) {
        return expression == null || expression.isEmpty();
    }
}
