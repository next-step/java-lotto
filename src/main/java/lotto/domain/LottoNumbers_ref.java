package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers_ref {
    private List<Integer> lottoNumbers;

    public LottoNumbers_ref(LottoNumberGeneratorStrategy_ref lottoNumberGeneratorStrategyRef) {
        lottoNumbers = new ArrayList<Integer>();
        makeLottoNumber(lottoNumberGeneratorStrategyRef);
    }

    private void makeLottoNumber(LottoNumberGeneratorStrategy_ref lottoNumberGeneratorStrategyRef) {
        lottoNumbers = lottoNumberGeneratorStrategyRef.generateLottoNumber();
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public MatchStatusOfALotto countMatchedNumbers(LastWonLottoNumber_ref lastWonLottoNumberRef) {
        int sameNumberCount = 0;
        boolean isBonusWon = false;
        for (int oneLottoNumber : lottoNumbers) {
            sameNumberCount = increaseIfSameNumber(sameNumberCount, oneLottoNumber, lastWonLottoNumberRef);
            isBonusWon = lastWonLottoNumberRef.containsBonus(oneLottoNumber);
        }
        return new MatchStatusOfALotto(sameNumberCount, isBonusWon);
    }

    private int increaseIfSameNumber(int currentSameNumberCount, int lottoNumber, LastWonLottoNumber_ref lastWonLottoNumberRef) {
        if (lastWonLottoNumberRef.containsMain(lottoNumber))
            return currentSameNumberCount + 1;
        return currentSameNumberCount;
    }

    public boolean contains(int checkNumber) {
        return lottoNumbers.contains(checkNumber);
    }
}
