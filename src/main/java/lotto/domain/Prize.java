package lotto.domain;

public enum Prize {
    FIRST(6, 2_000_000_000),
    //SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int matchCount;
    private final int prizeAmount;

    Prize(int matchCount, int prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public boolean isRight(int overlapNumberCount) {
        return this.matchCount == overlapNumberCount;
    }

    public int prizeCalculate(int count) {
        return this.prizeAmount * count;
    }
}
