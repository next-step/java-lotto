package lotto.prize;

import static java.util.Arrays.stream;

public enum LottoPrize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    LottoPrize(final int matchCount, final int prizeMoney) {
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

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
