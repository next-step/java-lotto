package lotto_auto.model;

import lotto_auto.ErrorMessage;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final Integer LOTTO_NUMBER_MIN_RANGE = 0;
    private static final Integer LOTTO_NUMBER_MAX_RANGE = 45;
    private final int number;

    public LottoNumber(int number) {
        throwIfInvalidLottoNumberRange(number);
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != obj.getClass()) return false;
        LottoNumber lottoNumber = (LottoNumber) obj;
        return this.number == lottoNumber.number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.number);
    }

    private void throwIfInvalidLottoNumberRange(int number) {
        if (number <= LOTTO_NUMBER_MIN_RANGE || number >= LOTTO_NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER);
        }
    }
}
