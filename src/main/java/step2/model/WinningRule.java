package step2.model;

public enum WinningRule {
    RULE_1(3, 5000),
    RULE_2(4, 50000),
    RULE_3(5, 15_000_000),
    RULE_4(6, 2_000_000_000);

    private int numberCount;
    private int winningPrice;

    WinningRule(int numberCount, int winningPrice) {
        this.numberCount = numberCount;
        this.winningPrice = winningPrice;
    }

    public int getNumberCount() {
        return numberCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
