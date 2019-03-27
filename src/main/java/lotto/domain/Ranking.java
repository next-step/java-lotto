package lotto.domain;

public enum Ranking {

    FIRST_CLASS(1, 6, 2_000_000_000),
    SECOND_CLASS(2, 5, 3_000_000),
    THIRD_CLASS(3, 5, 1_500_000),
    FOURTH_CLASS(4, 4, 50_000),
    FIFTH_CLASS(5, 3, 5_000),
    ZERO_CLASS(0, 0, 0);

    private int rank;
    private int countMatching;
    private int profit;

    Ranking(int rank, int countMatching, int profit) {
        this.rank = rank;
        this.countMatching = countMatching;
        this.profit = profit;
    }

    public int getRank() {
        return this.rank;
    }

    public int getCountMatching() {
        return this.countMatching;
    }

    public int getProfit() {
        return this.profit;
    }
}
