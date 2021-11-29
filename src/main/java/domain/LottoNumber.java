package domain;

import java.util.Objects;

import static controller.LottoGame.LOTTO_LAST_NUMBER;
import static controller.LottoGame.LOTTO_STARTING_NUMBER;

public class LottoNumber implements Comparable<LottoNumber> {

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
