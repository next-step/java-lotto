package lotto.model;

public enum Rank {
    FIRST(1, 6, 2000000000, false),
    SECOND(2, 5, 30000000, true),
    THIRD(3, 5, 1500000, false),
    FOURTH(4, 4, 50000, false),
    FIFTH(5, 3, 5000, false),
    MISS(6, 0, 0, false)
    ;

    private final int rank;
    private final int matchNumber;
    private final int prize;
    private int matchCount;
    private boolean isBonusValid;

    Rank(int rank, int matchNumber, int prize, boolean isBonusValid) {
        this.rank = rank;
        this.matchNumber = matchNumber;
        this.prize = prize;
        this.isBonusValid = isBonusValid;
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
        if (matchNumber == 1 || matchNumber == 2) {
            return MISS;
        }

        if (matchNumber == SECOND.getMatchNumber()) {
            return (matchBonus ? SECOND : THIRD);
        }

        for (Rank rank : Rank.values()) {
            if (rank.getMatchNumber() == matchNumber) {
                return rank;
            }
        }

       return null;
    }
}
