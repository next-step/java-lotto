package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    MISS(0, 0, (matchCount, isBonusMatched) -> matchCount <= 2),
    FIFTH(3, 5_000, (matchCount, isBonusMatched) -> matchCount == 3),
    FOURTH(4, 50_000, (matchCount, isBonusMatched) -> matchCount == 4),
    THIRD(5, 1_500_000, (matchCount, isBonusMatched) -> matchCount == 5 && !isBonusMatched),
    SECOND(5, 30_000_000, (matchCount, isBonusMatched) -> matchCount == 5 && isBonusMatched),
    FIRST(6, 2_000_000_000, (matchCount, isBonusMatched) -> matchCount == 6);

    private final int matchCount;
    private final int winningMoney;
    private final BiPredicate<Integer, Boolean> findCondition;

    Rank(int matchCount, int winningMoney, BiPredicate<Integer, Boolean> findCondition) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.findCondition = findCondition;
    }

    public static Rank findRank(int matchCount, boolean isBonusMatched) {
        return Arrays.stream(Rank.values())
                .filter(rank -> checkRankFindCondition(rank, matchCount, isBonusMatched))
                .findFirst()
                .orElse(MISS);
    }

    private static boolean checkRankFindCondition(Rank rank, int matchCount, boolean isBonusMatched) {
        return rank.findCondition
                .test(matchCount, isBonusMatched);
    }

    public int matchCount() {
        return matchCount;
    }

    public int winningMoney() {
        return winningMoney;
    }

    public boolean isSecond() {
        return this == SECOND;
    }
}
