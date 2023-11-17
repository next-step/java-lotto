package lotto.domain;

public class WinningAmount {
    private int winningAmount;

    public WinningAmount() {
        this.winningAmount = 0;
    }

    public WinningAmount(int amount) {
        this.winningAmount = amount;
    }

    public void add(int value) {
        this.winningAmount += value;
    }

    public int amount() {
        return winningAmount;
    }
}
