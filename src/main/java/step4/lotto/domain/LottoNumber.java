package step4.lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private static final int LOTTO_NUMBER_RANGE_MAX = 45;
    private static final int LOTTO_NUMBER_RANGE_MIN = 1;

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if(lottoNumber > LOTTO_NUMBER_RANGE_MAX || lottoNumber < LOTTO_NUMBER_RANGE_MIN){
            throw new IllegalArgumentException("로또 번호 범위가 아닙니다");
        }
        this.lottoNumber = lottoNumber;
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
