package calculator.domain;

public class Number {
    private final int value;

    public static Number valueOf(String value) {
        return new Number(Integer.parseInt(value));
    }

    public static Number valueOf(int value) {
        return new Number(value);
    }

    private Number(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
