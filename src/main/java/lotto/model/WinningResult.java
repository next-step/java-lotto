package lotto.model;

public enum WinningResult {
    FIFTH_PRICE(5_000),
    FOURTH_PRICE(50_000),
    THIRD_PRICE(1_500_000),
    SECOND_PRICE(30_000_000),
    FIRST_PRICE(2_000_000_000);

    private int winningAmount;

    WinningResult(int winningAmount) {
        this.winningAmount = winningAmount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
