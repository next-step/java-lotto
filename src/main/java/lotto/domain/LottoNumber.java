package lotto.domain;

import lotto.exceptions.LottoNumberRangeException;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int lottoNumber;

    public LottoNumber(String stringLottoNumber) {
        this(Integer.parseInt(stringLottoNumber));
    }

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(int i) {
        if (i < MIN_NUMBER || i > MAX_NUMBER) {
            throw new LottoNumberRangeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber1 = (LottoNumber) o;
        return lottoNumber == lottoNumber1.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
