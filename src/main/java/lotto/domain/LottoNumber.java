package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private static final int LOTTO_NUMBER_MIN_VALUE = 1;
    private static final int LOTTO_NUMBER_MAX_VALUE = 45;

    private final int value;

    public LottoNumber(int number) {
        this.validatePolicy(number);
        this.value = number;
    }

    private void validatePolicy(int number) {
        if (number < LOTTO_NUMBER_MIN_VALUE || number > LOTTO_NUMBER_MAX_VALUE) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber number = (LottoNumber) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
