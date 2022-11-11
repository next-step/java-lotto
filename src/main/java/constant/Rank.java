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

    public long findReward() {
        return reward;
    }
}
