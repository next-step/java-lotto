package step2.domain.rank.rankmatcher;

import step2.domain.rank.RankMatcher;
import step2.domain.lotto.Lotto;
import step2.domain.lotto.WinningLotto;

import java.util.Set;

public class GeneralRankMatcher implements RankMatcher {
    private final int requiredMatches;

    public GeneralRankMatcher(int requiredMatches) {
        this.requiredMatches = requiredMatches;
    }

    @Override
    public boolean matches(WinningLotto winningLotto, Lotto lotto) {
        Set<Integer> matchedNumbers = winningLotto.matchedWith(lotto);
        return matchedNumbers.size() == requiredMatches;
    }
}
