package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private final Integer number;

    public LottoNumber(Integer number) {
        this.number = number;
    }

    public boolean isEqualTo(final LottoNumber other) {
        return Objects.equals(number, other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
