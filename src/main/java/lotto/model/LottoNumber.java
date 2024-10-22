package lotto.model;

import lotto.utility.Validator;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        Validator.isValidNumber(number);
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
        return Integer.hashCode(number);
    }
}
