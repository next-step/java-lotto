package lotto;

public enum Rank {
    FIRST(6, 2_000_000_000, 0),
    SECOND_BONUS(5, 30_000_000, 1),
    SECOND(5, 1_500_000, 2),
    THIRD(4, 50_000, 3),
    FOURTH(3, 5_000, 4),
    MISS(0,0,5);

    private int matchedCount;
    private int prizeMoney;
    private int placeIndex;

    Rank(int matchedCount, int prizeMoney, int placeIndex) {
        this.matchedCount = matchedCount;
        this.prizeMoney = prizeMoney;
        this.placeIndex = placeIndex;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public int getMatchedCount() {
        return this.matchedCount;
    }

    public int getPlaceIndex() {
        return this.placeIndex;
    }

    public static Rank valueOf(int matchedCount, boolean matchBonus) {
        Rank result = Rank.MISS;
        for (Rank rank : Rank.values()) {
            result = checkExistMatchedNumber(matchedCount, matchBonus, result, rank);
        }
        return result;
    }

    private static Rank checkExistMatchedNumber(int matchedCount, boolean matchBonus, Rank result, Rank rank) {
        if (rank.getMatchedCount() == matchedCount) {
           result = getRank(rank, matchBonus);
        }
        return result;
    }

    private static Rank getRank(Rank rank, boolean matchBonus) {
        if (rank.getMatchedCount() == Rank.SECOND.getMatchedCount()) {
            return getSecond(matchBonus);
        }
        return rank;
    }

    private static Rank getSecond(boolean matchBonus) {
        if (matchBonus) {
            return Rank.SECOND_BONUS;
        }

        return Rank.SECOND;
    }
}
