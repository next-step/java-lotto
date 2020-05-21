package lotto.domain.lotto;

import java.util.Objects;

public class LottoNumber {
    private static final int MAX_VALUE = 45;
    private static final int MIN_VALUE = 1;
    private final int value;

    private LottoNumber(int value) {
        validation(value);
        this.value = value;
    }

    private void validation(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) throw new IllegalArgumentException();
    }

    public static LottoNumber create(int value) {
        return new LottoNumber(value);
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

    @Override
    public String toString() {
        return "LottoNumber{" +
                "value=" + value +
                '}';
    }
}
