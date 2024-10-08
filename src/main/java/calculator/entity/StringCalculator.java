package calculator.entity;

public class StringCalculator {

    public static int calculate(String text) {
        isBlank(text);
        return 0;
    }

    private static void isBlank(String text) {
        if (text == null || text.isBlank()) throw new IllegalArgumentException("빈 값 검증");
    }
}
