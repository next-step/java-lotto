package lotto;

import java.util.List;

public class Lotto {

    private static final int IS_BONUS_NUMBER_COUNT = 5;
    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean isBonusNumberMatched(int matchCount, int bonusNumber) {
        if (matchCount != IS_BONUS_NUMBER_COUNT) {
            return false;
        }
        return lottoNumbers.contains(bonusNumber);
    }
}
