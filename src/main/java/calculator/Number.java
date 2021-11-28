package calculator;

public class Number {
    private final int value;

    public Number(String text) {
        this(Integer.parseInt(text));
    }

    public Number(int value) {
        this.validatePositiveNumber(value);
        this.value = value;
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
