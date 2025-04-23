package lotto.domain;

public class CountAndBonusMatcher implements RankMatcher {
    private final int requiredCount;
    private final boolean requiredBonus;

    public CountAndBonusMatcher(int requiredCount, boolean requiredBonus) {
        this.requiredCount = requiredCount;
        this.requiredBonus = requiredBonus;
    }

    @Override
    public boolean match(int matchCount, boolean matchBonus) {
        return this.requiredCount == matchCount && this.requiredBonus == matchBonus;
    }
}
