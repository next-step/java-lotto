package domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_STARTING_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;

    private final int value;

    public LottoNumber(int value) {
        if (value < LOTTO_STARTING_NUMBER || value > LOTTO_LAST_NUMBER) {
            throw new IllegalArgumentException("Lotto number should be between 1 and 45.");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) object;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.value > lottoNumber.value ? 1 : -1;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
