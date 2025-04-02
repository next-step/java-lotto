package step2.domain.rank.rankmatcher;

import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoNumbers;
import step2.domain.lotto.WinningLotto;
import step2.domain.rank.RankMatcher;

public class SecondRankMatcher implements RankMatcher {

    public static final int TOTAL_NUMBERS_DRAWN = 6;
    public static final int BONUS_NUMBER_COUNT = 1;

    @Override
    public boolean matches(WinningLotto winningLotto, Lotto lotto) {
        LottoNumbers matchedNumbers = winningLotto.matchedWith(lotto);
        LottoNumbers notMatchedNumbers = winningLotto.notMatchedWith(lotto);

        return checkMatchedNumbers(matchedNumbers) && checkBonusNumbers(notMatchedNumbers, winningLotto);
    }

    @Override
    public String getAdditionalDescription() {
        return "보너스 볼 일치";
    }

    private boolean checkBonusNumbers(LottoNumbers notMatchedNumbers, WinningLotto winningLotto) {
        return notMatchedNumbers.size() == BONUS_NUMBER_COUNT && winningLotto.isBonusNumberPresent(notMatchedNumbers);
    }

    private boolean checkMatchedNumbers(LottoNumbers matchedNumbers) {
        return matchedNumbers.size() == TOTAL_NUMBERS_DRAWN - BONUS_NUMBER_COUNT;
    }
}
