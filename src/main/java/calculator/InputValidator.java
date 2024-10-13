package calculator;

public class InputValidator {
    public static void validate(String input) {
        validateBlank(input);
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열이나 공백으로 구성된 문자열은 허용되지 않습니다");
        }
    }
}
