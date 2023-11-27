package calculator.validator;

public class StringValidator {
    public static void validateForBlank(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("입력값을 입력해주세요");
        }
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }
}
