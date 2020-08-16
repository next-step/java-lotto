package lotto.domain;

import java.util.Objects;
import java.util.stream.Stream;

public class LottoNumber {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
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

    public static int valueOf(LottoNumber lottoNumber) {
        return lottoNumber.number;
    }
}
