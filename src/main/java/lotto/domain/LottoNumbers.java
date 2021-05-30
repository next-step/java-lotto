package lotto.domain;

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

    public MatchStatusOfALotto countMatchedNumbers(LastWonLottoNumber lastWonLottoNumber) {
        int sameNumberCount = 0;
        boolean isBonusWon = false;
        for (int oneLottoNumber : lottoNumbers) {
            sameNumberCount = increaseIfSameNumber(sameNumberCount, oneLottoNumber, lastWonLottoNumber);
            isBonusWon = lastWonLottoNumber.containsBonus(oneLottoNumber);
        }
        return new MatchStatusOfALotto(sameNumberCount, isBonusWon);
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
