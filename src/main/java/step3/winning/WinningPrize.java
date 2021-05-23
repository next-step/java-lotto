package step3.winning;

import java.util.Arrays;

public enum WinningPrize {
    ZERO(0, 0, "꽝"),
    FORTH(3, 5_000, "3개 일치 (5,000원)- %d개"),
    THIRD(4, 50_000, "4개 일치 (50,000원)- %d개"),
    SECOND(5, 1_500_000, "5개 일치 (1,500,000원)- %d개"),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)- %d개");

    private int winningCount;
    private int winningMoney;
    private String winningMessage;

    WinningPrize(int winningCount, int winningMoney, String winningMessage) {
        this.winningCount = winningCount;
        this.winningMoney = winningMoney;
        this.winningMessage = winningMessage;
    }

    public static WinningPrize valueOf(final int winningCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.winningCount == winningCount)
                .findFirst()
                .orElse(ZERO);
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

    public String getWinningMessage() {
        return this.winningMessage;
    }
}
