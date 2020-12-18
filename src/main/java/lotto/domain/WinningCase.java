package lotto.domain;

import java.util.Objects;

public class WinningCase {
    private final int sameNumberCount;
    private final int reward;

    public WinningCase(int sameNumberCount) {
        this.sameNumberCount = sameNumberCount;
        this.reward = RevenueTable.getRevenue(sameNumberCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningCase that = (WinningCase) o;
        return sameNumberCount == that.sameNumberCount && reward == that.reward;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sameNumberCount, reward);
    }

    public int getReward(int count) {
        return reward * count;
    }
}
