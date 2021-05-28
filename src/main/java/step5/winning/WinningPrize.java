package step5.winning;

import java.util.Arrays;

public enum WinningPrize {
    ZERO(0, 0, "꽝", false, 6),
    FIFTH(3, 5_000, "3개 일치 (5,000원)- %d개", false,5),
    FORTH(4, 50_000, "4개 일치 (50,000원)- %d개", false,4),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)- %d개", false,3),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치(30000000원)- %d개", true,2),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)- %d개", false, 1);

    private int winningCount;
    private int winningMoney;
    private String winningMessage;
    private boolean isBonusNumber;
    private int winningPrize;

    WinningPrize(int winningCount, int winningMoney, String winningMessage, boolean isBonusNumber, int winningPrize) {
        this.winningCount = winningCount;
        this.winningMoney = winningMoney;
        this.winningMessage = winningMessage;
        this.isBonusNumber = isBonusNumber;
        this.winningPrize = winningPrize;
    }

    public static WinningPrize valueOf(final int winningCount, final boolean isBonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> rank.winningCount == winningCount && rank.isBonusNumber == isBonusNumber)
                .findFirst()
                .orElse(ZERO);
    }

    public int getWinningPrize() {
        return this.winningPrize;
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

    public String getWinningMessage() {
        return this.winningMessage;
    }
}
