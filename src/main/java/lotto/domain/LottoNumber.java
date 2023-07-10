package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    public static final int LOTTO_START = 1;
    public static final int LOTTO_END = 45;

    private final Integer number;

    public LottoNumber(final Integer number) {
        verify(number);
        this.number = number;
    }

    private void verify(Integer number) {
        if (number < LOTTO_START || number > LOTTO_END) {
            throw new IllegalArgumentException(
                "lotto number should in range " + LOTTO_START + "~" + LOTTO_END);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
