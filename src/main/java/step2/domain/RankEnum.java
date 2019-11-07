package step2.domain;

public enum RankEnum {
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    FIVE_BONUS(5, 3_000_000),
    SIX_MATCH(6, 2_000_000_000);

    private static final int NO_REWARD = 0;

    private final int matchCount;
    private final int reward;

    RankEnum(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static int getReward(int hitCount) {
        int result = NO_REWARD;

        for (RankEnum rank : RankEnum.values()) {
            result += compare(rank, hitCount);
        }
        return result;
    }

    private static int compare(RankEnum rank, int hitCount) {
        return rank.matchCount == hitCount ? rank.reward : 0;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}

