package calculator;

public class Number {
    private final int value;

    public Number(String text) {
        this.value = Integer.parseInt(text);
        this.validatePositiveNumber(this.value);
    }

    public int getValue() {
        return value;
    }

    private void validatePositiveNumber(int value) {
        if (value < 0) {
            throw new RuntimeException();
        }
    }
}
