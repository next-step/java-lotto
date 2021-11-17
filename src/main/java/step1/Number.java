package step1;

import java.util.Objects;

public class Number {

    private final int number;

    public Number(final String number) {
        this(Integer.parseInt(number));
    }

    public Number(int number) {
        this.number = number;
        validate();
    }

    private void validate() {
        if (this.number < 0) {
            throw new RuntimeException("입력 숫자는 0보다 작을 수 없습니다");
        }
    }

    public Number add(Number other) {
        return new Number(this.number + other.number);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !o.getClass().equals(Number.class)) {
            return false;
        }
        Number other = (Number) o;
        return this.number == other.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
