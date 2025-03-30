package lotto.domain;

public class CountAndBonusMatchRule implements PrizeRankRule {
    private final MatchCount expectedMatchCount;
    private final boolean expectedBonus;

    public CountAndBonusMatchRule(MatchCount expectedMatchCount, boolean expectedBonus) {
        this.expectedMatchCount = expectedMatchCount;
        this.expectedBonus = expectedBonus;
    }

    @Override
    public boolean matches(MatchCount matchCount, boolean bonus) {
        return expectedMatchCount == matchCount && expectedBonus == bonus;
    }

    @Override
    public int getMatchCount() {
        return this.expectedMatchCount.getCount();
    }
}
