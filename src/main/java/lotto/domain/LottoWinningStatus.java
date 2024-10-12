package lotto.domain;

public enum LottoWinningStatus {
    THREE(3, 5_000, "3개 일치"),
    FOUR(4, 50_000, "4개 일치"),
    FIVE(5, 1_500_000, "5개 일치"),
    FIVE_AND_BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    SIX(6, 2_000_000_000, "6개 일치"),
    ;

    private final int winningCount;
    private final int amount;
    private final String description;

    LottoWinningStatus(int winningCount, int amount, String description) {
        this.winningCount = winningCount;
        this.amount = amount;
        this.description = description;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
