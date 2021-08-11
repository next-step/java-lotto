package step4;

import java.util.Objects;

public class LottoNumber {
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 46;

    private final int value;

    public LottoNumber(int value) {
        if (value < LOWER_BOUND || value > UPPER_BOUND) {
            throw new IllegalArgumentException("로또의 숫자 값은 1~46입니다.");
        }

        this.value = value;
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
