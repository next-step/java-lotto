package lotto.step2.domain;

import java.util.Objects;

public class LottoNumber {
    private final int LOTTO_MIN_NUMBER = 1;
    private final int LOTTO_MAX_NUMBER = 45;
    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (lottoNumber < LOTTO_MIN_NUMBER || lottoNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1~45 숫자만 가능 합니다.");
        }
        this.lottoNumber = lottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
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
