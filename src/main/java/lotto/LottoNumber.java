package lotto;

import java.util.Objects;

public final class LottoNumber {

    private final int value;

    private LottoNumber(final int value) {
        this.value = value;
    }

    public static LottoNumber of(final int value) {
        return new LottoNumber(value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNumber lottoNumber = (LottoNumber) o;
        return value == lottoNumber.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
