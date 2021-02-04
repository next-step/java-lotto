package lotto.controller;

import lotto.wrapper.Money;

import java.util.Arrays;

public enum Prize {
    THREE_MATCHES( 3,  new Money(5_000)),
    FOUR_MATCHES(4, new Money(50_000)),
    FIVE_MATCHES(5, new Money(1_500_000)),
    FIVE_BONUS_MATCHES(5, new Money(30_000_000)),
    SIX_MATCHES(6, new Money(2_000_000_000)),
    ZERO_MATCHES(0, new Money(0));


    private final int matchCount;

    public Money getPrize() {
        return prize;
    }

    private final Money prize;

    Prize(int matchCount, Money prize){
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Prize match(int matchCount, boolean matchBonus) {
        if(FIVE_BONUS_MATCHES.isEqualCount(matchCount) &&matchBonus) {
            return FIVE_BONUS_MATCHES;
        }
        return Arrays.stream(Prize.values())
                .filter(lottoCount -> lottoCount.isEqualCount(matchCount))
                .findFirst().orElse(ZERO_MATCHES);
    }

    public boolean isEqualCount(int matchCount) {
        return this.matchCount == matchCount;
    }
}
