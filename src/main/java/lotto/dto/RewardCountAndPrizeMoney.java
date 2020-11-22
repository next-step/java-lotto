package lotto.dto;

import lotto.domain.Money;

public class RewardCountAndPrizeMoney {
    private final int hitTimes;
    private final int count;
    private final long prizeMoney;

    public RewardCountAndPrizeMoney(final int hitTimes, final int count, final Money prizeMoney) {
        this.hitTimes = hitTimes;
        this.count = count;
        this.prizeMoney = prizeMoney.getValue();
    }

    public int getHitTimes() {
        return hitTimes;
    }

    public int getCount() {
        return count;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
