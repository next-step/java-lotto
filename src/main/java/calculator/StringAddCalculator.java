package calculator;

public class StringAddCalculator {
    public static int calculate(String expression) {
        if (isNullOrEmpty(expression)) {
            return 0;
        }
        return Integer.parseInt(expression);
    }

    private static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }
}
