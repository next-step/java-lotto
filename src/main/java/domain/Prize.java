package domain;

public class Prize {
    private int winningCount;
    private int winningMoney;

    private Prize(int winningCount, int winningMoney) {
        this.winningCount = winningCount;
        this.winningMoney = winningMoney;
    }

    public static Prize of() {
        return new Prize(0, 0);
    }

    public void increase(int money) {
        this.winningCount++;
        this.winningMoney += money;
    }

    public long getWinningMoney() {
        return this.winningMoney;
    }

    public int getWinningCount() {
        return this.winningCount;
    }
}
