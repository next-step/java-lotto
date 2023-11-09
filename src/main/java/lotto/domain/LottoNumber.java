package lotto.domain;

import lotto.validate.NumberValidation;

import static lotto.validate.NumberValidation.checkNumberRange;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int number;

    public LottoNumber(int number) {
        checkNumberRange(number);
        this.number = number;
    }

    public int number() {
        return number;
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
