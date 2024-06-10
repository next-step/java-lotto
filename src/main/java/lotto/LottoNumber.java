package lotto;

import java.util.Objects;

public class LottoNumber {
    private final Integer number;
    public LottoNumber(final Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(getNumber(), that.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
