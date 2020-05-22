package calculator;

import java.util.Objects;

public class Number {

    private final static int ZERO_NUMBER = 0;

    private int value;

    private Number(int value) {
        validate(value);
        this.value = value;
    }

    public Number(String inputValue) {
        this(Integer.parseInt(inputValue));
    }

    private void validate(int value) {
        if (value < ZERO_NUMBER) {
            throw new RuntimeException("0 이하의 값을 입력했습니다.");
        }
    }

    public Number add(Number number) {
        return new Number(this.value + number.value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
