package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int value;

    public LottoNumber(int value) {
        validateNumberRange(value);
        this.value = value;
    }

    private void validateNumberRange(int value) {
        if (MIN_NUMBER > value || MAX_NUMBER < value) {
            throw new IllegalArgumentException("입력값은 1이상 45이하 입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
