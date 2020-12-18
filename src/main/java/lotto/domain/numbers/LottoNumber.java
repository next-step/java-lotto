package lotto.domain.numbers;

import lotto.domain.LottoNumberCache;

import java.util.Objects;

public class LottoNumber {
    private final int value;

    public LottoNumber(final int value) {
        this.value = value;
    }

    public static LottoNumber of(final int value) {
        return LottoNumberCache.findByKey(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
