package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    static final int MIN_NUM = 1;
    static final int MAX_NUM = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validLottoNumberRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validLottoNumberRange(Integer number) {
        if (number > MAX_NUM || number < MIN_NUM) {
            throw new IllegalArgumentException(number + "이 입력되었습니다. 로또 번호는 1~45까지만 존재합니다.");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.lottoNumber, o.lottoNumber);
    }
}
