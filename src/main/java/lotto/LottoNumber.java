package lotto;

import java.util.Objects;

public class LottoNumber {
    private final int value;

    public LottoNumber(int input) {
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException("로또 숫자는 1 이상 45 이하여야 합니다.");
        }

        this.value = input;
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

    @Override
    public String toString() {
        return "LottoNumber{" +
                "value=" + value +
                '}';
    }
}
