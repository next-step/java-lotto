package calculator;

public class PositiveNumber {
    private final int value;

    private PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }

    static PositiveNumber from(String text) {
        int value = Integer.parseInt(text);
        return new PositiveNumber(value);
    }

    PositiveNumber plus(PositiveNumber other) {
        return new PositiveNumber(this.value + other.value);
    }

    PositiveNumber minus(PositiveNumber other) {
        return new PositiveNumber(this.value - other.value);
    }

    PositiveNumber multiply(PositiveNumber other) {
        return new PositiveNumber(this.value * other.value);
    }

    PositiveNumber divide(PositiveNumber other) {
        return new PositiveNumber(this.value / other.value); // 문제에서 항상 나누어 떨어진다고 가정
    }

    int toInt() {
        return value;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("음수는 허용하지 않습니다: " + value);
        }
    }
}
