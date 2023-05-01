package calculator.domain;

public class Number {

    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public Number(String value) {
        if (value == null) {
            throw new IllegalArgumentException("null 은 허용하지 않습니다.");
        }
        this.value = Integer.parseInt(value);
    }

    public int value() {
        return this.value;
    }
}
