package lotto.domain.reward;

import lotto.domain.Money;

import java.util.Arrays;

public enum Reward {
    NONE(2, Money.of(0)),
    HIT_THREE_TIMES(3, Money.of(5_000)),
    HIT_FOUR_TIMES(4, Money.of(50_000)),
    HIT_FIVE_TIMES(5, Money.of(1_500_000)),
    HIT_SIX_TIMES(6, Money.of(2_000_000_000));

    private final int hitTimes;
    private final Money money;

    Reward(final int hitTimes, final Money money) {
        this.hitTimes = hitTimes;
        this.money = money;
    }

    public boolean isMatch(final int hitTimes) {
        if (hitTimes <= NONE.hitTimes) {
            return false;
        }
        return this.hitTimes == hitTimes;
    }

    public int getHitTimes() {
        return hitTimes;
    }

    public Money getMoney() {
        return money;
    }

    public static Reward find(final int hitTimes) {
        return Arrays.stream(Reward.values())
                .filter(reward -> reward.isMatch(hitTimes))
                .findAny()
                .orElse(NONE);
    }
}
