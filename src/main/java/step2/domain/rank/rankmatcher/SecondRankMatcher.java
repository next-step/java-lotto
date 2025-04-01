package step2.domain.rank.rankmatcher;

import step2.domain.rank.RankMatcher;
import step2.domain.lotto.Lotto;
import step2.domain.lotto.WinningLotto;

import java.util.Set;

public class SecondRankMatcher implements RankMatcher {

    public static final int TOTAL_NUMBERS_DRAWN = 6;
    public static final int BONUS_NUMBER_COUNT = 1;

    @Override
    public boolean matches(WinningLotto winningLotto, Lotto lotto) {
        Set<Integer> matchedNumbers = winningLotto.matchedWith(lotto);
        Set<Integer> notMatchedNumbers = winningLotto.notMatchedWith(lotto);

        return checkMatchedNumbers(matchedNumbers) && checkBonusNumbers(notMatchedNumbers, winningLotto);
    }

    private boolean checkBonusNumbers(Set<Integer> notMatchedNumbers, WinningLotto winningLotto) {
        return notMatchedNumbers.size() == BONUS_NUMBER_COUNT && winningLotto.isBonusNumberPresent(notMatchedNumbers);
    }

    private boolean checkMatchedNumbers(Set<Integer> matchedNumbers) {
        return matchedNumbers.size() == TOTAL_NUMBERS_DRAWN - BONUS_NUMBER_COUNT;
    }
}
