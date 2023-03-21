package lottoGame;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),

    BOOM(2, false, 0);


    public int matchingCount;
    public boolean hasBonusNumber;
    public int prize;

    Rank(int matchingCount, boolean hasBonusNumber, int prize) {
        this.matchingCount = matchingCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public static int getPrize(Rank rank, int count) {
        return rank.prize * count;
    }

    public static Rank getRank(int matchCount, boolean matchBonus) {
        for (Rank rank : Rank.values()) {
            if(rank.matchingCount == matchCount && rank.hasBonusNumber == matchBonus) {
                return rank;
            }
        }
        return Rank.BOOM;
    }
}
