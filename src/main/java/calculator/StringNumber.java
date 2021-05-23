package calculator;

public final class StringNumber {

    private Integer value;

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
            throw new IllegalArgumentException();
        }
    }

    public Integer getValue() {
        return value;
    }

}
