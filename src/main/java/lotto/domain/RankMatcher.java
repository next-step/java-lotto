package lotto.domain;

import java.util.Objects;

public class RankMatcher {
    private int sameNumberCount;
    private boolean bonus;

    public RankMatcher(int sameNumberCount, boolean bonus) {
        this.sameNumberCount = sameNumberCount;
        this.bonus = bonus;
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public boolean haveBonus() {
        return bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RankMatcher that = (RankMatcher) o;
        return sameNumberCount == that.sameNumberCount &&
                bonus == that.bonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sameNumberCount, bonus);
    }
}
