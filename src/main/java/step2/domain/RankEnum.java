package step2.domain;

public enum RankEnum {
    MISS(0, 0),
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    FIVE_BONUS(5, 3_000_000),
    SIX_MATCH(6, 2_000_000_000);

    private static final int WINNING_MIN_COUNT = 3;

    private final int matchCount;
    private final int reward;

    RankEnum(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static RankEnum valueOf(int matchCount, boolean isBounsMatch) {
        if (matchCount < WINNING_MIN_COUNT) {
            return MISS;
        }

        RankEnum rank = valueOf(matchCount);
        if (FIVE_BONUS.matchCount(matchCount)) {
            return isBounsMatch ? FIVE_BONUS : FIVE_MATCH;
        }
        return rank;
    }

    private static RankEnum valueOf(int matchCount) {
        for (RankEnum rank : values()) {
            if (rank.matchCount(matchCount)) {
                return rank;
            }
        }
        throw new IllegalArgumentException(matchCount + "는 유효하지 않은 값입니다.");
    }

    private boolean matchCount(int countOfMatch) {
        return this.matchCount == countOfMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public boolean checkZeroReward() {
        return this == RankEnum.MISS;
    }
}

