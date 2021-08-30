package lotto.domain;

public enum LottoRank {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int sameNumberCount;
    private final int winnings;

    LottoRank(int sameNumberCount, int winnings) {
        this.sameNumberCount = sameNumberCount;
        this.winnings = winnings;
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public int getWinnings() {
        return winnings;
    }
}
