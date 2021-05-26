package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoNumbers {
    private List<Integer> lottoNumbers;
    private int sameNumberCount = 0;
    private boolean isBonusWon = false;

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
        for (int oneLottoNumber : lottoNumbers) {
            updateCount(isSameNumber(oneLottoNumber, lastWonLottoNumber));
        }
        SameNumberCountInALotto sameNumberCountInALotto = new SameNumberCountInALotto(sameNumberCount, isBonusWon); //생성자로 멤버변수셋팅
        return sameNumberCountInALotto;
    }

    public void updateCount(SameNumberStateEnum sameNumberStateEnum) {
        if (sameNumberStateEnum == SameNumberStateEnum.SAME_MAIN_NUMBER)
            sameNumberCount++;
        if (sameNumberStateEnum == SameNumberStateEnum.SAME_BONUS_NUMBER)
            isBonusWon = true;
    }

    private SameNumberStateEnum isSameNumber(int oneLottoNumber, LastWonLottoNumber lastWonLottoNumber) {
        if (lastWonLottoNumber.containsMain(oneLottoNumber))
            return SameNumberStateEnum.SAME_MAIN_NUMBER;

        if (lastWonLottoNumber.containsBonus(oneLottoNumber))
            return SameNumberStateEnum.SAME_BONUS_NUMBER;

        return SameNumberStateEnum.NO_SAME;
    }

    public boolean contains(int checkNumber) {
        return lottoNumbers.contains(checkNumber);
    }
}
