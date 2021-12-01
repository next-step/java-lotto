package step2.domain;

import java.util.Objects;

public class Number {
    private final int number;

    public Number(int number) {
        validateNumbers(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateNumbers(int number) {
        if (number > 0) {
            return;
        }

        throw new RuntimeException("입력 숫자 오류");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number that = (Number) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
