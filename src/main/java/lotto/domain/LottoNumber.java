package lotto.domain;

import lotto.exception.InputError;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;

    private final int lottoNumber;

    public LottoNumber(final int lottoNumber) {
        validLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(String number) {
        int lottoNumber = Integer.parseInt(number);
        return new LottoNumber(lottoNumber);
    }

    private void validLottoNumber(int lottoNumber) {
        if (MAX_NUMBER < lottoNumber || MIN_NUMBER > lottoNumber) {
            throw new InputError("올바른 로또 번호가 아닙니다. 1부터 45사이의 숫자여야 합니다.");
        }
    }

    public int value() {
        return lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber otherLottoNumber) {
        return this.lottoNumber - otherLottoNumber.lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

}
