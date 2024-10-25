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

    private MatchCount matchCount;
    private int winningAmount;

    LottoRank(int matchCount, int winningAmount) {
        this.matchCount = new MatchCount(matchCount);
        this.winningAmount = winningAmount;
    }

    public int getMatchCount() {
        return matchCount.getMatchCount();
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

    public static Set<MatchCount> getMatchCounts() {
        return EnumSet.allOf(LottoRank.class)
                .stream()
                .filter(d -> !d.matchCount.equals(new MatchCount(0)))
                .map(d -> d.matchCount)
                .collect(Collectors.toSet());
    }

    public static boolean isWinning(MatchCount matchCount) {
        return getMatchCounts().contains(matchCount);
    }

    public static LottoRank getLottoRank(int matchCount, boolean isBonusMatch) {
        if (matchCount < FIFTH.matchCount.getMatchCount()) {
            return MISS;
        }
        if (SECOND.matchCount.getMatchCount() == matchCount) {
            return rankSecondAndThird(isBonusMatch);
        }

        return Arrays.stream(values())
                .filter(rank -> rank.isMatch(new MatchCount(matchCount)))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }


    public static LottoRank getLottoRank(MatchCount matchCount, boolean isBonusMatch) {
        if (matchCount.getMatchCount() < FIFTH.matchCount.getMatchCount()) {
            return MISS;
        }
        if (SECOND.matchCount.equals(matchCount)) {
            return rankSecondAndThird(isBonusMatch);
        }

        return Arrays.stream(values())
                .filter(rank -> rank.isMatch(matchCount))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean isMatch(MatchCount matchCount) {
        return this.matchCount.equals(matchCount);
    }

    private static LottoRank rankSecondAndThird(boolean isBonusMatch) {
        if (isBonusMatch) {
            return SECOND;
        }
        return THIRD;
    }

    public static int determineAmountByMatchCount(MatchCount matchCount, boolean isBonusMatch) {
        return getLottoRank(matchCount, isBonusMatch).winningAmount;
    }
}
