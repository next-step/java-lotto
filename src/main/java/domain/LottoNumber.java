package domain;

import java.util.Objects;

public class LottoNumber {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;
    private final int value;

    public LottoNumber(final int value) {
        if (value < LOWER_BOUND || value > UPPER_BOUND) {
            throw new IllegalArgumentException("로또 번호는 1이상 45이하의 자연수여야 합니다.");
        }

        this.value = value;
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
}
