package step2.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Reward {
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
        return this.hitTimes == hitTimes;
    }

    public Money getMoney() {
        return money;
    }

    public static Optional<Reward> find(final int hitTimes) {
        return Arrays.stream(Reward.values())
                .filter(reward -> reward.isMatch(hitTimes))
                .findAny();
    }
}
