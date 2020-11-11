package study.calculator;

public class Number {

    private final int value;

    private Number(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("숫자는 0보다 커야합니다.");
        }

        this.value = value;
    }

    public static Number of(String value) {
        return new Number(Integer.parseInt(value));
    }

    public static Number zero() { return new Number(0); }

    public int getValue() {
        return value;
    }

    public Number plus(Number number) {
        return new Number(this.value + number.value);
    }


}
