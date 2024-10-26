package refactoringlotto.domain;

import java.util.Objects;

public class LottoNumber {
    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
        checkNumberRange();
    }

    private void checkNumberRange() {
        if (lottoNumber<=0 || lottoNumber>45) {
            throw new IllegalArgumentException();
        }
    }
    protected int getLottoNumber() {
        return lottoNumber;
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
        return Objects.hashCode(lottoNumber);
    }
}
