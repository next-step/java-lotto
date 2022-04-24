package lotto;

import java.util.List;

public class Lotteries {

    private static final int IS_BONUS_NUMBER_COUNT = 5;
    private List<Integer> lottoNumbers;

    public Lotteries(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean isMatchedNumber(Integer winningLottoNumber) {
        return lottoNumbers.contains(winningLottoNumber);
    }

    public boolean isBonusNumberMatched(int matchCount, int bonusNumber) {
        if (matchCount != IS_BONUS_NUMBER_COUNT) {
            return false;
        }
        return lottoNumbers.contains(bonusNumber);
    }
}
