package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        checkValidNumbers(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void checkValidNumbers(int lottoNumber) {
        if (isValidLottoNumber(lottoNumber))
            throw new IllegalArgumentException("입력한 로또 번호가 1부터 45사이여야합니다.");
    }

    private boolean isValidLottoNumber(int lottoNumber) {
        return lottoNumber < START_LOTTO_NUMBER || lottoNumber > END_LOTTO_NUMBER;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.lottoNumber, o.lottoNumber);
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

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

}
