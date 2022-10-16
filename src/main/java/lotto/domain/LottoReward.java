package lotto.domain;

import lotto.domain.Money.ImmutableMoney;

public enum LottoReward {

    FIRST(new ImmutableMoney(2_000_000_000), 6), SECOND(new ImmutableMoney(30_000_000), 5), THIRD(new ImmutableMoney(1_500_000), 5),
    FOURTH(new ImmutableMoney(50_000), 4), FIFTH(new ImmutableMoney(5_000), 3),
    SIXTH(new ImmutableMoney(0), 2), SEVENTH(new ImmutableMoney(0), 1), EIGHTH(new ImmutableMoney(0), 0);

    private final ImmutableMoney reward;
    private final int count;

    LottoReward(final ImmutableMoney reward, final int count) {
        this.reward = reward;
        this.count = count;
    }

    public static ImmutableMoney reward(final int rank) {
        return values()[rank - 1].reward;
    }

    public static int count(final int rank) {
        return LottoReward.values()[rank - 1].count;
    }
}
