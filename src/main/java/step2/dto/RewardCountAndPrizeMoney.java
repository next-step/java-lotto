package step2.dto;

import step2.domain.Money;

public class RewardCountAndPrizeMoney {
    private final int hitTimes;
    private final int count;
    private final int prizeMoney;

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

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
