package lotto.prize;

import lotto.model.Money;

import static java.util.Arrays.stream;

public enum LottoPrize {
    FIRST(6, Money.from(2_000_000_000)),
    SECOND(5, Money.from(30_000_000)),
    THIRD(5, Money.from(1_500_000)),
    FOURTH(4, Money.from(50_000)),
    FIFTH(3, Money.from(5_000)),
    NONE(0, Money.from(0));

    private final int matchCount;
    private final Money prizeMoney;

    LottoPrize(final int matchCount, final Money prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoPrize valueOf(final MatchInformation matchInformation) {
        return stream(values())
                .filter(prize -> matchInformation.isMatchCountEq(prize.matchCount))
                .filter(prize -> !prize.equals(SECOND) || matchInformation.isMatchBonus())
                .findFirst()
                .orElse(LottoPrize.NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getPrizeMoney() {
        return prizeMoney;
    }
}
