package lotto.domain;

public enum WinningPrize {
    THREE(3, 5000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_WITH_BONUS(5, 30_000_000, true),
    SIX(6, 2_000_000_000);

    public static WinningPrize getPrizeByMatchCount(int matchCount, boolean isBonus) {
        if (matchCount == 5 && isBonus) {
            return FIVE_WITH_BONUS;
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

    public boolean isBonus() {
        return isBonus;
    }

    private final int matchCount;
    private final int prizeMoney;
    private final boolean isBonus;

    WinningPrize(int matchCount, int prizeMoney) {
        this(matchCount, prizeMoney, false);
    }

    WinningPrize(int matchCount, int prizeMoney, boolean isBonus) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.isBonus = isBonus;
    }

    public static int getPrizeMoney(int matchCount, boolean isBonus) {
        WinningPrize prize = getPrizeByMatchCount(matchCount, isBonus);
        if (prize != null) {
            return prize.getPrizeMoney();
        }
        return 0;
    }
}
