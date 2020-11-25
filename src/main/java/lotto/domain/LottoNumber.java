package lotto.domain;

import lotto.message.ErrorMessage;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_NUMBER_RANGE_START = 1;
    public static final int LOTTO_NUMBER_RANGE_END = 45;
    private final Integer number;

    public LottoNumber(Integer number) {
        this.number = number;
        validate();
    }

    private void validate() {
        if(this.number < LOTTO_NUMBER_RANGE_START || this.number > LOTTO_NUMBER_RANGE_END){
            throw new RuntimeException(ErrorMessage.INVALID_BALL_NUMBER_RANGE);
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number.compareTo(o.number);
    }

    @Override
    public String toString() {
        return number.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
