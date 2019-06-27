package lotto.model;

import java.util.Objects;

public class LottoNumber {

    private final int NUMBER;

    public LottoNumber(int NUMBER) {
        this.NUMBER = NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return NUMBER == that.NUMBER;
    }

    @Override
    public int hashCode() {
        return Objects.hash(NUMBER);
    }
}
