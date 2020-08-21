package domain;

public enum WinnerRanking {
    RANK_ONE(2000000000,6 ),
    RANK_TWO(1500000, 5),
    RANK_THREE(50000, 4),
    RANK_FOUR(5000, 3);

    private int winnerPrice;
    private int count ;

    WinnerRanking(int winnerPrice, int count) {
        this.winnerPrice = winnerPrice;
        this.count= count;
    }

    public int getWinnerPrice() {
        return winnerPrice;
    }

    public int getCount() {
        return count;
    }
}
