package lotto.step2.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final String LOTTO_NUMBER_RANGE_EXCEED_EXCEPTION_MESSAGE = "로또번호 범위를 초과하였습니다.";
    private static final int LOTTO_MIN_NUMBER = 0;
    private static final int LOTTO_MAX_NUMBER = 45;
    
    private final int lottoNumber;
    
    public LottoNumber(int lottoNumber) {
        if (lottoNumber < LOTTO_MIN_NUMBER || lottoNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_EXCEED_EXCEPTION_MESSAGE);
        }
        
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
