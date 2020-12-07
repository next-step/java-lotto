package step3.VO;

import step3.LottoGenerator;
import step3.ResultNumber;
import step3.Statistic;

import java.util.List;
import java.util.Objects;

public class Lotto {
    public final List<LottoNumber> numberList;

    public Lotto(LottoGenerator lottoGenerator) {
        this.numberList = lottoGenerator.getLottoNumbers();
    }

    public void checkReward(Statistic statistic, ResultNumber resultNumber) {
        int winningCnt = resultNumber.checkLottoResult(this.numberList);
        boolean bonusResult = resultNumber.checkBonusResult(this.numberList);

        statistic.recordLottoResult(winningCnt, bonusResult);
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
