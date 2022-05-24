package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    public static final int LOTTO_ALL_NUMBER = 45;
    public static final int LOTTO_MINIMUM_NUMBER = 1;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateNumber(lottoNumber);
        
        this.lottoNumber = lottoNumber;
    }

    private void validateNumber(int lottoNumber) {
        if (LOTTO_MINIMUM_NUMBER > lottoNumber || LOTTO_ALL_NUMBER < lottoNumber) {
            throw new IllegalArgumentException("로또숫자의 범위가 올바르지 않습닌다.");
        }
    }

    public boolean isSameNumber(LottoNumber lottoNumber) {
        return this.equals(lottoNumber);
    }

    public int getLottoNumber() {
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
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "lottoNumber=" + lottoNumber +
                '}';
    }
}
