package lottoAuto.model;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_MATCH(0, 0);

    private int matchCount;
    private int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank findByRank(int countMatchWinningNumbers, boolean hasBonusBall) {
        if (countMatchWinningNumbers == SECOND.matchCount && hasBonusBall) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == countMatchWinningNumbers && rank != SECOND)
                .findAny()
                .orElse(NO_MATCH);
    }

    public static String makeMessage(Rank rank) {
        return rank.matchCount + "개 일치 (" + rank.prize + "원)";
    }

    public static BigDecimal calculatePrize(Rank rank, Long count) {
        return BigDecimal.valueOf(rank.prize).multiply(BigDecimal.valueOf(count));
    }
}
