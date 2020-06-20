package lotto.model;

public enum Rank {
    FIRST(1, 6, 2000000000),
    SECOND(2, 5, 30000000),
    THIRD(3, 5, 1500000),
    FOURTH(4, 4, 50000),
    FIFTH(5, 3, 5000),
    MISS(6, 0, 0)
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

    public static Rank getValue(int matchNumber, boolean matchBonus) {
        if (matchNumber == 1 || matchNumber == 2) {
            return MISS;
        }

        for (Rank rank : Rank.values()) {
            if (rank.getMatchNumber() == matchNumber) {
                return rank;
            }
        }

       return null;
    }
}
