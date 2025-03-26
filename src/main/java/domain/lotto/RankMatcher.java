package domain.lotto;

import domain.MatchedCount;

public class RankMatcher {

    private final int requiredMatches;

    public RankMatcher(int requiredMatches) {
        this.requiredMatches = requiredMatches;
    }

    public boolean matches(MatchedCount matchedCount) {
        return matchedCount.isSame(requiredMatches);
    }
}
