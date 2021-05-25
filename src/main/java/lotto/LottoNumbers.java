package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private List<Integer> lottoNumbers;

    public LottoNumbers(LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy) {
        lottoNumbers = new ArrayList<Integer>();
        makeLottoNumber(lottoNumberGeneratorStrategy);
    }

    private void makeLottoNumber(LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy) {
        lottoNumbers = lottoNumberGeneratorStrategy.generateLottoNumber();
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public SameNumberCountInALotto countMatchedNumbers(LastWonLottoNumber lastWonLottoNumber) {
        SameNumberCountInALotto sameNumberCountInALotto = new SameNumberCountInALotto();
        for (int oneLottoNumber : lottoNumbers) {
            sameNumberCountInALotto.updateCount(isSameNumber(oneLottoNumber, lastWonLottoNumber));
        }
        return sameNumberCountInALotto;
    }

    private SameNumberStateEnum isSameNumber(int oneLottoNumber, LastWonLottoNumber lastWonLottoNumber) {
        if (lastWonLottoNumber.containsMain(oneLottoNumber))
            return SameNumberStateEnum.SAME_MAIN_NUMBER;

        if (lastWonLottoNumber.containsBonus(oneLottoNumber))
            return SameNumberStateEnum.SAME_BONUS_NUMBER;

        return SameNumberStateEnum.NO_SAME;
    }
}
