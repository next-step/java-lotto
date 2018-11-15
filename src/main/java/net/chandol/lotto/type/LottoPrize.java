package net.chandol.lotto.type;

import net.chandol.lotto.value.Money;

import java.util.Arrays;
import java.util.Objects;

public enum LottoPrize {
    _1(6, false, Money.of(2_000_000_000)),
    _2(5, true, Money.of(30_000_000)),
    _3(5, false, Money.of(1_500_000)),
    _4(4, false, Money.of(50_000)),
    _5(3, false, Money.of(5_000)),
    NONE;

    private boolean needMatch = false;
    private Integer matchCount;
    private Money prize = Money.ZERO;

    LottoPrize() {
    }

    LottoPrize(Integer matchCount, Boolean needMatch, Money prize) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.needMatch = needMatch;
    }

    public Boolean getNeedMatch() {
        return needMatch;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Money getPrize() {
        return prize;
    }

    private boolean isMatch(int count, boolean matchBonus) {
        boolean isCountMatch = Objects.equals(count, this.matchCount);
        return this.needMatch ? isCountMatch && matchBonus : isCountMatch;
    }

    public static LottoPrize getMatchingPrize(int count, boolean matchBonus) {
        return Arrays.stream(LottoPrize.values())
                .filter(p -> p.isMatch(count, matchBonus))
                .findFirst().orElse(NONE);
    }
}
