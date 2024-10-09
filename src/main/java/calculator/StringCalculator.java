package calculator;

public class StringCalculator {

    public static void splitAndCalculate(String expression) {
        if (isBlankOrNull(expression)) {
            throw new IllegalArgumentException("입력값이 null 또는 빈 공백 문자입니다.");
        }
    }

    private static boolean isBlankOrNull(String expression) {
        return expression == null || expression.isEmpty();
    }
}
