package lotto;

import java.util.Objects;

public class LottoNumber {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;

    private final int value;

    /*
        CONSTRUCTOR
     */
    public LottoNumber(int value) {
        validateRange(value);

        this.value = value;
    }

    /*
        FUNCTION
     */
    private void validateRange(int value) {
        if (value < LOWER_BOUND || value > UPPER_BOUND) {
            throw new IllegalArgumentException("로또번호는 1이상 45이하입니다.");
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
}
