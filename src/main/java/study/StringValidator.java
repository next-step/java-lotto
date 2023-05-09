package study;

public class StringValidator {
    public static void validateIsBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }
}
