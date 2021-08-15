package lotto.model;

import java.util.Objects;

public class LottoNumber {
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;

    private final int number;

    public LottoNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
           throw new IllegalArgumentException();
        }

        this.number = number;
    }

    public int getNumber() {
        return number;
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
