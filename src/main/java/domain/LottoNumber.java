package domain;

import java.util.Objects;

public class LottoNumber {

    static final int START_INCLUSIVE = 1;
    static final int END_EXCLUSIVE = 46;
    private final int value;

    public LottoNumber(final int value) {
        if (value < START_INCLUSIVE || value >= END_EXCLUSIVE) {
            throw new IllegalArgumentException("로또 번호는 1 이상 46 미만의 자연수여야 합니다.");
        }

        this.value = value;
    }

    public int getValue() {
        return value;
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
