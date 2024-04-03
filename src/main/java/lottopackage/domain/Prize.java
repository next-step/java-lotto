package lottopackage.domain;

public enum Prize {
    FIRST(1, 6, 2000000000),
    //SECOND(2, 6, 30000000),
    THIRD(3, 5, 1500000),
    FOURTH(4, 4, 50000),
    FIFTH(5, 3, 5000),
    SIXTH(6, 0, 0);

    public final int same;
    public final int winningAmount;
    public final int prizeNumber;

    Prize(int value, int same, int winningPrize) {
        this.prizeNumber = value;
        this.same = same;
        this.winningAmount = winningPrize;
    }

    public int getPrizeNumber() {
        return prizeNumber;
    }

}
