package lotto.model;

import java.util.Objects;

public class LottoNumber {
    private final int number;

    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    public LottoNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
           throw new IllegalArgumentException();
        }

        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
