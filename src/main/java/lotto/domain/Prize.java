package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Prize {
    NO_RANK(0, BigDecimal.ZERO),
    RANK_4TH(3, BigDecimal.valueOf(5000)),
    RANK_3TH(4, BigDecimal.valueOf(50000)),
    RANK_2TH(5, BigDecimal.valueOf(1500000)),
    RANK_2TH_WITH_BONUS(5, BigDecimal.valueOf(30000000)),
    RANK_1TH(6, BigDecimal.valueOf(2000000000));

    private int winningCount;
    private BigDecimal prizeMoney;

    Prize(int winningCount, BigDecimal prizeMoney) {
        this.winningCount = winningCount;
        this.prizeMoney = prizeMoney;
    }

    public static Prize findPrize(int winningCount) {
        return Arrays.stream(values()).filter(v -> v.getWinningCount() == winningCount).findAny()
                     .orElse(Prize.NO_RANK);
    }

    public static Prize findPrize(int winningCount, boolean containBonusNum) {
        if (winningCount == Prize.RANK_2TH.getWinningCount() && containBonusNum) {
            return Prize.RANK_2TH_WITH_BONUS;
        }

        return findPrize(winningCount);
    }

    public int getWinningCount() {
        return winningCount;
    }

    public BigDecimal getPrizeMoney() {
        return prizeMoney;
    }
}
