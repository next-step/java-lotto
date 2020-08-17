package domain;

public class WinningCount {
    private int winningNumber;

    private WinningCount(int winningNumber) {
        this.winningNumber = winningNumber;
    }

    public static WinningCount of() {
        return new WinningCount(0);
    }

    public static WinningCount of(int winningNumber) {
        return new WinningCount(winningNumber);
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
