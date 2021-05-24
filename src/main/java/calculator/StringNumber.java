package calculator;

public final class StringNumber {

    private int value;

    public StringNumber(final String input) {
        if (input == null || input.isEmpty()) {
            this.value = 0;
            return;
        }
        validateInput(input);
    }

    private void validateInput(String input) {
        value = Integer.parseInt(input);
        if (value < 0) {
            throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
    }

}
