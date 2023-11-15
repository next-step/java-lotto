package lotto.domain.lotto.wrapper;

import java.util.Objects;

public class LottoNumber {

    private static final int MIN = 1;
    private static final int MAX = 45;

    private int number;

    public LottoNumber(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException("숫자의 범위는 1~45입니다.");
        }

        this.number = number;
    }

    private boolean isOutOfRange(int number) {
        return number < MIN || number > MAX;
    }

    public int number() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber = (LottoNumber) o;
        return number == lottoNumber.number;
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

