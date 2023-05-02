package step2.domain.vo;

import java.util.Objects;

public class Number {

    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;

    private final Integer number;

    public Number(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자만 가능합니다. 현재 숫자: " + number);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;

        return Objects.equals(getNumber(), number1.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
