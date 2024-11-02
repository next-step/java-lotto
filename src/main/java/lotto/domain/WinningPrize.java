package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;

public enum WinningPrize {
    FIFTH(3, 5000, 5),
    FOURTH(4, 50_000, 4),
    THIRD(5, 1_500_000, 3),
    SECOND(5, 30_000_000, 2, true),
    FIRST(6, 2_000_000_000, 1);

    public static WinningPrize getPrizeByMatchCount(int matchCount, boolean isBonus) {
        if (matchCount == 5 && isBonus) {
            return SECOND;
        }
        for (WinningPrize prize : values()) {
            if (prize.getMatchCount() == matchCount && !prize.isBonus()) {
                return prize;
            }
        }
        return null;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getRank() {
        return rank;
    }

    public boolean isBonus() {
        return isBonus;
    }

    private final int matchCount;
    private final int prizeMoney;
    private final int rank;
    private final boolean isBonus;
    private int count = 0;

    WinningPrize(int matchCount, int prizeMoney, int rank) {
        this(matchCount, prizeMoney, rank, false);
    }

    WinningPrize(int matchCount, int prizeMoney, int rank, boolean isBonus) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.rank = rank;
        this.isBonus = isBonus;
    }

    public static int getPrizeMoney(int matchCount, boolean isBonus) {
        WinningPrize prize = getPrizeByMatchCount(matchCount, isBonus);
        if (prize != null) {
            return prize.getPrizeMoney();
        }
        return 0;
    }

    public static WinningPrize[] valuesSortedByRank() {
        return Arrays.stream(values())
                .sorted(Comparator.comparingInt(WinningPrize::getRank).reversed())
                .toArray(WinningPrize[]::new);
    }

    public void incrementCount() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }
    
}
