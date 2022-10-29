package lotto.domain;

public enum Rank {

    FIRST(6, 6, 2_000_000_000),
    BONUS(7, 5, 30_000_000),
    SECOND(5, 5, 1_500_000),
    THIRD(4, 4, 50000),
    FOURTH(3, 3, 5000),
    ;

    private final int match;
    private final int rank;
    private final int prize;

    Rank(int match, int rank, int prize) {
        this.match = match;
        this.rank = rank;
        this.prize = prize;
    }

    public int getMatch() {
        return this.match;
    }

    public  int getRank() {
        return this.rank;
    }

    public int getPrize() {
        return this.prize;
    }

}
