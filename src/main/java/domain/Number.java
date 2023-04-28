package domain;

public class Number {
    private final int value;

    public Number(String value) {
        try {
            this.value = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number: " + value);
        }
    }

    public Number(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
