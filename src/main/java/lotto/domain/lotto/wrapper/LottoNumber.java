package lotto.domain.lotto.wrapper;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN = 1;
    private static final int MAX = 45;

    private final int number;

    public LottoNumber(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(String.format("숫자의 범위는 %d ~ %d입니다.", MIN, MAX));
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

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }
}

