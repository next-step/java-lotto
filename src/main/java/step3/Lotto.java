package step3;

import step3.VO.LottoNumber;

import java.util.List;
import java.util.Objects;

public class Lotto {
    public final List<LottoNumber> numberList;

    public Lotto(LottoGenerator lottoGenerator) {
        this.numberList = lottoGenerator.getLottoNumbers();
    }

    public void checkReward() {
        int winningCnt = ResultNumber.checkLottoResult(this.numberList);
        boolean bonusResult = ResultNumber.checkBonusResult(this.numberList);

        Statistic.recordLottoResult(winningCnt, bonusResult);
    }

    public List<LottoNumber> getNumberList(){
        return numberList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numberList, lotto.numberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberList);
    }
}
