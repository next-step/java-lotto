package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (1 > lottoNumber || lottoNumber > 45) {
            throw new IllegalArgumentException("1 ~ 45 사이의 숫자만 입력할 수 있습니다.");
        }
        this.lottoNumber = lottoNumber;
    }

    public boolean isMatchBonus(LottoNumber bonusNumber) {
        return this.lottoNumber == bonusNumber.lottoNumber;
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
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.lottoNumber, other.lottoNumber);
    }
}
