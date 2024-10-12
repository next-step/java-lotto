package lotto.domain;

public enum LottoWinningStatus {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000),
    ;

    private final int winningCount;
    private final int amount;

    LottoWinningStatus(int winningCount, int amount) {
        this.winningCount = winningCount;
        this.amount = amount;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getAmount() {
        return amount;
    }
}
