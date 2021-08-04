package lotto.prize;

import java.util.function.Function;

import static java.util.Arrays.stream;

public enum LottoPrize {
    FIRST(6, 2_000_000_000, matchInfo -> matchInfo.isMatchCountEq(6)),
    SECOND(5, 30_000_000, matchInfo -> isSecond(matchInfo)),
    THIRD(5, 1_500_000, matchInfo -> isThird(matchInfo)),
    FOURTH(4, 50_000, matchInfo -> matchInfo.isMatchCountEq(4)),
    FIFTH(3, 5_000, matchInfo -> matchInfo.isMatchCountEq(3)),
    NONE(0, 0, matchInfo -> matchInfo.isMatchCountNone(2));

    private final int matchCount;
    private final int prizeMoney;
    private final Function<MatchInformation, Boolean> judge;

    LottoPrize(final int matchCount, final int prizeMoney, Function<MatchInformation, Boolean> judge) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.judge = judge;
    }

    private static boolean isSecond(MatchInformation matchInfo) {
        return matchInfo.isMatchCountEq(5) && matchInfo.isMatchBonus();
    }

    private static boolean isThird(MatchInformation matchInfo) {
        return matchInfo.isMatchCountEq(5) && !matchInfo.isMatchBonus();
    }

    public static LottoPrize valueOf(final MatchInformation matchInformation) {
        return stream(values())
                .filter(lottoPrize -> lottoPrize.judge.apply(matchInformation))
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
