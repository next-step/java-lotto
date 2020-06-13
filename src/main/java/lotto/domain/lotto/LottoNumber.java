package lotto.domain.lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber create(int lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber out) {
        if (this.lottoNumber > out.lottoNumber)
            return 1;
        if (this.lottoNumber < out.lottoNumber)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber lottoNumber = (LottoNumber) o;
        return this.lottoNumber == lottoNumber.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
