package lotto.domian;

import lotto.exception.LottoNumberOutOfRangeException;

import java.util.Objects;

import static lotto.common.ConstantSet.MIN_LOTTO_NUMBER;
import static lotto.common.ConstantSet.MAX_LOTTO_NUMBER;

public class LottoNumber implements Comparable<LottoNumber>{
    private final int lottoNumber;

    private LottoNumber(final int lottoNumber){
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int lottoNumber){
        validateLottoNumberRange(lottoNumber);
        return new LottoNumber(lottoNumber);
    }

    private static void validateLottoNumberRange(int number){
        if(number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER){
            throw new LottoNumberOutOfRangeException();
        }
    }

    public int getLottoNumber(){
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
