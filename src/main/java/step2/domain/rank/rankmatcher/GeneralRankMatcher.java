package step2.domain.rank.rankmatcher;

import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoNumbers;
import step2.domain.lotto.WinningLotto;
import step2.domain.rank.RankMatcher;

public class GeneralRankMatcher implements RankMatcher {
    private final int requiredMatches;

    public GeneralRankMatcher(int requiredMatches) {
        this.requiredMatches = requiredMatches;
    }

    @Override
    public boolean matches(WinningLotto winningLotto, Lotto lotto) {
        LottoNumbers matchedNumbers = winningLotto.matchedWith(lotto);
        return matchedNumbers.size() == requiredMatches;
    }
}
