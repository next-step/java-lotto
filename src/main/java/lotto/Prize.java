package lotto;

import java.math.BigDecimal;

public enum Prize {
    RANK_4TH(3, BigDecimal.valueOf(5000)),
    RANK_3TH(4, BigDecimal.valueOf(50000)),
    RANK_2TH(5, BigDecimal.valueOf(1500000)),
    RANK_1TH(6, BigDecimal.valueOf(2000000000));

    private int winningCount;
    private BigDecimal prizeMoney;

    Prize(int winningCount, BigDecimal prizeMoney) {
        this.winningCount = winningCount;
        this.prizeMoney = prizeMoney;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public BigDecimal getPrizeMoney() {
        return prizeMoney;
    }
}
