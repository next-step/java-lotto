package lotto.domain;

public enum Winning {
    NO_MATCH(0, 0),
    FOURTH(5000, 4),
    THIRD(50000, 3),
    SECOND(1500000, 2),
    FIRST(2000000000, 1);

    private int prize;
    private int rank;

    public int getPrize() {
        return prize;
    }

    public int getRank() {
        return rank;
    }

    Winning(int prize, int rank) {
        this.prize = prize;
        this.rank = rank;
    }
}