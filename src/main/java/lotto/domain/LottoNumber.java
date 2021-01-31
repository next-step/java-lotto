package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private static final int SMALLEST = 1;
    private static final int LARGEST = 45;

    private final int number;

    public LottoNumber(final int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < SMALLEST || number > LARGEST) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 수만 가능합니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}