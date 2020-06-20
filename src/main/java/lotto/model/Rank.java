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
    private int matchCount;

    Rank(int rank, int matchNumber, int prize) {
        this.rank = rank;
        this.matchNumber = matchNumber;
        this.prize = prize;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void plusCount() {
        this.matchCount++;
    }

    public static Rank getValue(int matchNumber, boolean matchBonus) {
        Rank rankType = null;

        if (matchNumber == 1 || matchNumber == 2) {
            return MISS;
        }

        for (Rank rank : Rank.values()) {
            if (rank.getMatchNumber() == matchNumber) {
                rankType = rank;
                break;
            }
        }

        if (rankType == SECOND && !matchBonus) {
            rankType = THIRD;
        }

       return rankType;
    }
}
