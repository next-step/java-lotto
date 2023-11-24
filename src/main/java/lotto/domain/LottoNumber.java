package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int value;

    public LottoNumber(int value) {
        this.value = value;
        validate();
    }

    private void validate() {
        if (this.value < MIN_LOTTO_NUMBER || this.value > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(String.format("로또숫자는 %d~%d 사이의 숫자만 가능합니다.", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
        }
    }

    public int value() {
        return this.value;
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
