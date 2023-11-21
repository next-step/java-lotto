package lotto.domain;

import static lotto.message.LottoErroMessage.*;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int number;

    public LottoNumber(int number) {
        checkNumberRange(number);
        this.number = number;
    }

    public int number() {
        return number;
    }

    private void checkNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(NOT_ENOUGH_LOTTO_NUMBER_RANGE.message());
        }
    }

    public void checkNumberRange() {
        checkNumberRange(this.number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LottoNumber) {
            return number == ((LottoNumber) obj).number;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(number, o.number);
    }
}
