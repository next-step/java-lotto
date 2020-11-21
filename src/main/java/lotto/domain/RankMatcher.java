package lotto.domain;

import java.util.Objects;

public class RankMatcher {
    int sameNumberCount;
    boolean matchBonusNumber;

    public RankMatcher(int sameNumberCount, boolean matchBonusNumber) {
        this.sameNumberCount = sameNumberCount;
        this.matchBonusNumber = matchBonusNumber;
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RankMatcher that = (RankMatcher) o;
        return sameNumberCount == that.sameNumberCount &&
                matchBonusNumber == that.matchBonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sameNumberCount, matchBonusNumber);
    }
}
