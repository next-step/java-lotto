package domain;

public class WinningCount {
    private int winningNumber;

    public WinningCount() {
        this(0);
    }

    public WinningCount(int winningNumber) {
        this.winningNumber = winningNumber;
    }

    public void increase() {
        this.winningNumber++;
    }

    public int calculateWinningMoney(int money) {
        return money * winningNumber;
    }

    public int getValue() {
        return this.winningNumber;
    }
}
