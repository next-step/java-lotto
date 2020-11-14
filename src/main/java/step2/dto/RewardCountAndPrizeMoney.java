package step2.dto;

import step2.domain.Money;

public class RewardCountAndPrizeMoney {
    private final int count;
    private final int prizeMoney;

    public RewardCountAndPrizeMoney(final int count, final Money prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney.getValue();
    }

    public int getCount() {
        return count;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
