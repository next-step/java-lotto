package lotto.step2.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int lottoNumber;
    
    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
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
    
    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
