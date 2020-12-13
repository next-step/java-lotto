package lotto.domain.numbers;

import java.util.Objects;

public class LottoNumber {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    private final int value;

    public LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (LOTTO_START_NUMBER > value || value > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(
                    String.format("숫자는 %d부터 %d까지여야 합니다.", LOTTO_START_NUMBER, LOTTO_END_NUMBER));
        }
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
