package lotto.model;

public enum Rank {
    ALL_MATCH(1,6, 2000000000),
    MISS_ONE(2, 5, 1500000),
    MISS_TWO(3, 4, 50000),
    MISS_THREE(4, 3,5000),
//        NONE(5, 0, 0)
    ;

    private final int rank;
    private final int matchNumber;
    private final int prize;
    private int count;

    Rank(int rank, int matchNumber, int prize) {
        this.rank = rank;
        this.matchNumber = matchNumber;
        this.prize = prize;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    public void plusCount() {
        this.count++;
    }
}
