package domain;

public enum WinnerRanking {
    RANK_ONE(2_000_000_000, 6),
    RANK_TWO(1_500_000, 5),
    RANK_THREE(50_000, 4),
    RANK_FOUR(5_000, 3);

    private int winnerPrice;
    private int count;

    WinnerRanking(int winnerPrice, int count) {
        this.winnerPrice = winnerPrice;
        this.count = count;
    }

    public int getWinnerPrice() {
        return winnerPrice;
    }

    public int getCount() {
        return count;
    }
}
