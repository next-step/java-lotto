package calculator;

import java.util.Objects;

public class PositiveNumber {
    private final int number;

    public PositiveNumber(int number) {
        this.number = validate(number);
    }

    private int validate(int number) {
        if (number < 0) {
            throw new NumberFormatException("0보다 큰 값을 입력해야합니다.");
        }
        return number;
    }

    public int getNumber() {
        return number;
    }

    public PositiveNumber sum(PositiveNumber number) {
        return new PositiveNumber(this.number + number.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositiveNumber)) return false;
        PositiveNumber that = (PositiveNumber) o;
        return getNumber() == that.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
