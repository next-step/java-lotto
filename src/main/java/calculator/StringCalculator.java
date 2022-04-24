package calculator;

public class StringCalculator {

    public static int calculate(String value) {
        if (isNullOrBlank(value)) {
            throw new IllegalArgumentException();
        }
        return 0;
    }

    private static boolean isNullOrBlank(String value) {
        return value == null || value.isBlank();
    }
}
