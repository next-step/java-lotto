package lotto;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int matchCount;
    private int winningAmount;

    LottoRank(int matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public static List<LottoRank> getAllLottoRank() {
        return EnumSet.allOf(LottoRank.class)
                .stream()
                .filter(rank -> rank != MISS)
                .collect(Collectors.toList());
    }

    public static Set<Integer> getMatchCounts() {
        return EnumSet.allOf(LottoRank.class)
                .stream()
                .filter(d -> d.matchCount != 0)
                .map(d -> d.matchCount)
                .collect(Collectors.toSet());
    }

    public static boolean isWinning(int matchCount) {
        return getMatchCounts().contains(matchCount);
    }

    public static LottoRank getLottoRank(int matchCount, boolean isBonusMatch) {
        if (matchCount < FIFTH.matchCount) {
            return MISS;
        }
        if (SECOND.matchCount == matchCount) {
            return rankSecondAndThird(isBonusMatch);
        }

        return Arrays.stream(values())
                .filter(rank -> rank.isMatch(matchCount))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean isMatch(int matchCount) {
        return this.matchCount == matchCount;
    }

    private static LottoRank rankSecondAndThird(boolean isBonusMatch) {
        if (isBonusMatch) {
            return SECOND;
        }
        return THIRD;
    }

    public static int determineAmountByMatchCount(int matchCount, boolean isBonusMatch) {
        return getLottoRank(matchCount, isBonusMatch).winningAmount;
    }
}
