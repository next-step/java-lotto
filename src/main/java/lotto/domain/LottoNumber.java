package lotto.domain;

import lotto.CustomIllegalArgumentException;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 45;

    private int number;

    public LottoNumber(int number) throws CustomIllegalArgumentException {
        checkValidValue(number);
        this.number = number;
    }

    private void checkValidValue(int number) throws CustomIllegalArgumentException {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new CustomIllegalArgumentException(Message.ERROR_LOTTO_NUMBER_OUT_OF_RANGE,
                                                    MIN_VALUE, MAX_VALUE);
        }
    }

    public int number() {
        return this.number;
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
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }
}
