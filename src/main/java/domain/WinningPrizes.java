package domain;

public enum WinningPrizes {
    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(3000000),
    THIRD_PRIZE(1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000);

    private int prizeMoney;

    WinningPrizes(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int calculatePrizeMoney(int count) {
        return this.prizeMoney * count;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }
}
