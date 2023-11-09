package lotto.step1.calculator;

public class UserInput {
    private final String userInput;

    public UserInput(final String input) {
        validateUserInputString(input);

        this.userInput = input;
    }

    public String[] split() {
        return userInput.split(" ");
    }

    private void validateUserInputString(final String input) {
        validateNullAndEmpty(input);
    }

    private void validateNullAndEmpty(final String input) {
        validateNull(input);
        validateEmpty(input);
    }

    private void validateEmpty(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력은 빈 공백이 될 수 없습니다.");
        }
    }

    private void validateNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력은 null이 될 수 없습니다.");
        }
    }
}
