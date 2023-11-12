package study.step1.domain.dto;

public class Input {
    private final String input;

    public Input(String input) {
        validate(input);
        this.input = input;
    }

    private void validate(String input) {
        if (isValidInput(input)) {
            throw new IllegalArgumentException("InputError: 입력값 오류(빈 값 혹은 공백)");
        }
    }
    private boolean isValidInput(String input) {
        return input == null || input.isEmpty();
    }
}
