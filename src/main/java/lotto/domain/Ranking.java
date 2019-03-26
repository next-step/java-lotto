package lotto.domain;

public enum Ranking {

    FIRST_CLASS(1, 6, 2000000000),
    SECOND_CLASS(2, 5, 1500000),
    THIRD_CLASS(3, 4, 50000),
    FOURTH_CLASS(4, 3, 5000),
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
