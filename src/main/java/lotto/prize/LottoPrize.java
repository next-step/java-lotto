package lotto.prize;

import java.util.function.Predicate;

import static java.util.Arrays.stream;

public enum LottoPrize {
    FIRST(6, 2_000_000_000) {
        @Override
        boolean judge(final MatchInformation matchInfo, final int matchCount) {
            return matchInfo.isMatchCountEq(matchCount);
        }
    },
    SECOND(5, 30_000_000) {
        @Override
        boolean judge(final MatchInformation matchInfo, final int matchCount) {
            return matchInfo.isMatchCountEq(matchCount) && matchInfo.isMatchBonus();
        }
    },
    THIRD(5, 1_500_000) {
        @Override
        boolean judge(final MatchInformation matchInfo, final int matchCount) {
            return matchInfo.isMatchCountEq(matchCount) && !matchInfo.isMatchBonus();
        }
    },
    FOURTH(4, 50_000) {
        @Override
        boolean judge(final MatchInformation matchInfo, final int matchCount) {
            return matchInfo.isMatchCountEq(matchCount);
        }
    },
    FIFTH(3, 5_000) {
        @Override
        boolean judge(final MatchInformation matchInfo, final int matchCount) {
            return matchInfo.isMatchCountEq(matchCount);
        }
    },
    NONE(0, 0) {
        @Override
        boolean judge(final MatchInformation matchInfo, final int matchCount) {
            return matchInfo.isMatchCountNone(matchCount);
        }
    };

    private final int matchCount;
    private final int prizeMoney;

    abstract boolean judge(final MatchInformation matchInfo, int matchCount);

    LottoPrize(final int matchCount, final int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoPrize valueOf(final MatchInformation matchInformation) {
        return stream(values())
                .filter(getLottoPrizePredicate(matchInformation))
                .findFirst()
                .orElse(LottoPrize.NONE);
    }

    private static Predicate<LottoPrize> getLottoPrizePredicate(final MatchInformation matchInformation) {
        return lottoPrize -> lottoPrize.judge(matchInformation, lottoPrize.matchCount);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
