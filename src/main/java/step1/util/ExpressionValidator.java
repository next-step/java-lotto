package step1.util;

public class ExpressionValidator {

    private ExpressionValidator() {

    }

    public static void validate(String expression) {
        if (isNullOrBlank(expression)) {
            throw new IllegalArgumentException("유효한 수식 문자열을 입력해주세요.");
        }
    }

    private static boolean isNullOrBlank(String value) {
        return value == null || value.isBlank();
    }
}
