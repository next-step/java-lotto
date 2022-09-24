package lotto.step2.domain;

import java.util.Objects;

public class LottoNumber {
    private final int lottoNumber;
    
    public LottoNumber(int lottoNumber) {
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
