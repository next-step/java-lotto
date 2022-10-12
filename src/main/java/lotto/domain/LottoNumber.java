package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(final int number) {
        if (number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER) {
            String exceptionMessage = String.format("로또 숫자 범위(%d ~ %d) 내 숫자만 가질 수 있습니다.",
                    MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER);
            throw new IllegalArgumentException(exceptionMessage);
        }

        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}