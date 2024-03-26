package lotto.domain.lotto;

import lotto.error.ErrorCode;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN = 1;
    public static final int MAX = 45;

    private final int value;

    public LottoNumber(int value) {
        assertNumberInRange(value);
        this.value = value;
    }

    public LottoNumber(String value) {
        this(Integer.parseInt(value));
    }

    public int value() {
        return this.value;
    }

    private void assertNumberInRange(int value) {
        if (value < MIN || MAX < value) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_INVALID_NUMBER.message());
        }
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

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.value, other.value());
    }
}
