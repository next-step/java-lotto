package lotto.domain;

public enum Jackpot {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private int numOfCorrected;
    private int prizeMoney;

    Jackpot(int numOfCorrected, int prizeMoney) {
        this.numOfCorrected = numOfCorrected;
        this.prizeMoney = prizeMoney;
    }

    public int getNumOfCorrected() {
        return numOfCorrected;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
