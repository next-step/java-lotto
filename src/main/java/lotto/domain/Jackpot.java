package lotto.domain;

public enum Jackpot {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

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
