package step2.model;

public enum WinningRule {
    RULE_1(3, 5000),
    RULE_2(4, 50000),
    RULE_3(5, 15_000_000),
    RULE_4(6, 2_000_000_000);

    private int noCnt;
    private int winningPrice;

    WinningRule(int noCnt, int winningPrice) {
        this.noCnt = noCnt;
        this.winningPrice = winningPrice;
    }

    public int getNoCnt() {
        return noCnt;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
