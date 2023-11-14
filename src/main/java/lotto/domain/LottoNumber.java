package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }

    private void validate(int lottoNumber) {
        if (lottoNumber < LottoNumberFactory.MIN_LOTTO_BOUND || lottoNumber > LottoNumberFactory.MAX_LOTTO_BOUND) {
            throw new IllegalArgumentException("로또의 번호 범위를 벗어났습니다.");
        }
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
