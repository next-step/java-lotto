package constant;

public enum Rank {
    FIRST(2000000000L),
    SECOND(1500000L),
    SECOND_WITH_BONUS(30000000L),
    THIRD(50000L),
    FOURTH(5000L),
    UNKNOWN(0L);

    private final long reward;

    Rank(long reward) {
        this.reward = reward;
    }

    public static Rank findRank(int countOfMatchedNumber) {
        switch (countOfMatchedNumber) {
            case 6:
                return Rank.FIRST;
            case 5:
                return Rank.SECOND;
            case 7:
                return Rank.SECOND_WITH_BONUS;
            case 4:
                return Rank.THIRD;
            case 3:
                return Rank.FOURTH;
            default:
                return Rank.UNKNOWN;
        }
    }

    public long findReward() {
        return reward;
    }
}
