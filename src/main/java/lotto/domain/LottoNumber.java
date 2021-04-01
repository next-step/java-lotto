package lotto.domain;

import lotto.exception.LottoException;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{

    private static final int NUMBER_RANGE_MIN = 1;
    private static final int NUMBER_RANGE_MAX = 45;
    private static final String NUMBER_RANGE_OFF_MESSAGE = "1부터 45사이의 숫자를 입력해주세요";
    private final int number;

    public LottoNumber(final Integer number) {
        if (number < NUMBER_RANGE_MIN || number > NUMBER_RANGE_MAX) {
            throw new LottoException(NUMBER_RANGE_OFF_MESSAGE);
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
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
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.number - lottoNumber.number;
    }
}
