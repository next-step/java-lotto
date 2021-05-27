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
        int sameNumberCount = 0;
        boolean isBonusWon = false;
        for (int oneLottoNumber : lottoNumbers) {
            sameNumberCount = increaseIfSameNumber(sameNumberCount, oneLottoNumber, lastWonLottoNumber);
            isBonusWon = lastWonLottoNumber.containsBonus(oneLottoNumber);
        }
        return new SameNumberCountInALotto(sameNumberCount, isBonusWon);
    }

    private int increaseIfSameNumber(int currentSameNumberCount, int lottoNumber, LastWonLottoNumber lastWonLottoNumber) {
        if (lastWonLottoNumber.containsMain(lottoNumber))
            return currentSameNumberCount + 1;
        return currentSameNumberCount;
    }

    public boolean contains(int checkNumber) {
        return lottoNumbers.contains(checkNumber);
    }
}
