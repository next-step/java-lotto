package step2.domain.rank;

public class RankMatcher {

    private final int requiredMatches;

    public RankMatcher(int requiredMatches) {
        this.requiredMatches = requiredMatches;
    }

    public boolean matches(MatchedCount matchedCount) {
        return matchedCount.isSame(requiredMatches);
    }
}
