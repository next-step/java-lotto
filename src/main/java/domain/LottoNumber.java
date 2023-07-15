package domain;

import java.util.Objects;

public class LottoNumber {

    static final int LOWER_BOUND = 1;
    static final int UPPER_BOUND = 45;
    private final int value;

    public LottoNumber(final int value) {
        validateBound(value);

        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validateBound(final int value) {
        if (isOutOfBound(value)) {
            throw new IllegalArgumentException(
                "로또 번호는 " + LOWER_BOUND + " 이상 " + UPPER_BOUND + " 이하의 자연수여야 합니다.");
        }
    }

    private boolean isOutOfBound(final int value) {
        return value < LOWER_BOUND || value > UPPER_BOUND;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
