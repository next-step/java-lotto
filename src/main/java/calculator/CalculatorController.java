package calculator;

public class CalculatorController {

    public static void validateInput(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }
}
