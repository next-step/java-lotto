package lotto;

import java.util.List;
import java.util.Objects;

public class LottoNumber {
    private final List<Integer> lottoNumber;

    public LottoNumber(List<Integer> lottoNumber) {
        LottoValidationUtils.validationLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int isCollectNumber(Integer winNumber) {
        return lottoNumber.contains(winNumber) ? 1 : 0;
    }

    public boolean lottoSize(int expectedSize) {
        return lottoNumber.size() == expectedSize;
    }

    public int compareWinLottoNumber(Lotto winLottoNumber) {
        int collectNumber = 0;
        for(Integer winNumber : lottoNumber){
            collectNumber += winLottoNumber.containNumber(winNumber);
        }
        return collectNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
