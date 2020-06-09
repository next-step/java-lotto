package lotto.model;

import java.util.Objects;

public class RewardLotto {

    private int matchingCount;
    private boolean isMatchingBonus;

    public RewardLotto(int matchingCount, boolean isMatchingBonus) {
        this.matchingCount = matchingCount;
        this.isMatchingBonus = isMatchingBonus;
    }

    public int getMatchingCount() {
        return this.matchingCount;
    }

    public boolean isMatchingBonus() {
        return this.isMatchingBonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RewardLotto that = (RewardLotto) o;
        return matchingCount == that.matchingCount &&
                isMatchingBonus == that.isMatchingBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchingCount, isMatchingBonus);
    }
}
