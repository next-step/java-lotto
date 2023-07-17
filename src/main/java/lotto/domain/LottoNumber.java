package lotto.domain;

import java.util.Objects;
import java.util.StringJoiner;

public final class LottoNumber {

    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 45;

    private final int value;

    public LottoNumber(final int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(
                    String.format("로또 번호는 %d 이상 %d 미만의 자연수여야 합니다.", MIN_VALUE, MAX_VALUE)
            );
        }

        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LottoNumber.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }
}
