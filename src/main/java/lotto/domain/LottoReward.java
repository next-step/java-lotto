package lotto.domain;

import lotto.domain.Money.ImmutableMoney;

public enum LottoReward {

    FIRST(new ImmutableMoney(2_000_000_000)), SECOND(new ImmutableMoney(30_000_000)), THIRD(new ImmutableMoney(1_500_000)),
    FOURTH(new ImmutableMoney(50_000)), FIFTH(new ImmutableMoney(5_000)),
    SIXTH(new ImmutableMoney(0)), SEVENTH(new ImmutableMoney(0)), EIGHTH(new ImmutableMoney(0));

    private final ImmutableMoney reward;

    LottoReward(final ImmutableMoney reward) {
        this.reward = reward;
    }

    public static ImmutableMoney reward(final Rank rank) {
        return values()[rankIndex(rank)].reward;
    }

    private static int rankIndex(final Rank rank) {
        return rank.rankValue() - 1;
    }
}
