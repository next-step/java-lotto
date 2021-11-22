package domain;

public class Rank {
    private final int rank;
    private final int bonusBall;

    public Rank(int rank, int bonusBall) {
        this.rank = rank;
        this.bonusBall = bonusBall;
    }

    public int rank() {
        return rank;
    }

    public int bonusBall() {
        return bonusBall;
    }
}
