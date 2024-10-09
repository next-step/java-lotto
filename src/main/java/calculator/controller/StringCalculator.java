package calculator.controller;

public class StringCalculator {
    public StringCalculator(String text) {
        validate(text);
    }

    private void validate(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("빈 값 검증");
        }
    }
}
