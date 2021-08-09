package step2.model;

public enum WinningRule {
    RULE_2(4, 50000),
    RULE_3(5, 15000000),
    RULE_1(3, 5000),
    RULE_4(6, 2000000000);

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
