package autolotto.constant;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final long winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank find(int countOfMatch, boolean hasBonusBall) {
        if (isSecond(countOfMatch, hasBonusBall)) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> rank != SECOND && rank.getCountOfMatch() == countOfMatch)
                .findFirst()
                .orElse(MISS);
    }

    private static boolean isSecond(int countOfMatch, boolean hasBonusBall) {
        return countOfMatch == SECOND.getCountOfMatch() && hasBonusBall;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public long getWinningMoney() {
        return winningMoney;
    }
}
