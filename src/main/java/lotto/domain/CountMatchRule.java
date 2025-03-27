package lotto.domain;

public class CountMatchRule implements PrizeRankRule {
    private final MatchCount expected;

    public CountMatchRule(MatchCount expected) {
        this.expected = expected;
    }

    @Override
    public boolean matches(MatchCount matchCount, boolean bonus) {
        return expected == matchCount;
    }

    @Override
    public int getMatchCount() {
        return this.expected.getCount();
    }
}
