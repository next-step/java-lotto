package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 45;

    private final int number;

    public LottoNumber(int number) {
        checkArgumentValidation(number);
        this.number = number;
    }

    private void checkArgumentValidation(int number) {
        if (number < RANGE_START || number > RANGE_END) {
            throw new IllegalArgumentException("LottoNumber는 항상 1~45 사이 값 입니다.");
        }
    }

    public int number() {
        return this.number;
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

    @Override
    public String toString() {
        return "" + number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }
}
