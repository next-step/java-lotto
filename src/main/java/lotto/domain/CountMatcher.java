package lotto.domain;

public class CountMatcher implements RankMatcher {
    private final int requiredCount;

    public CountMatcher(int requiredCount) {
        this.requiredCount = requiredCount;
    }

    @Override
    public boolean match(int matchCount, boolean matchBonus) {
        return this.requiredCount == matchCount;
    }
}
