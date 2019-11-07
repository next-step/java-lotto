package step2.domain;

public enum RankEnum {
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    SIX_MATCH(6, 2_000_000_000);

    private int matchCount;
    private int reward;

    RankEnum(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static int getReward(int hit) {
        int result = 0;

        for(RankEnum rank : RankEnum.values()) {
            result = compare(rank, hit);
            if(result > 0) break;
        }
        return result;
    }

    private static int compare(RankEnum rank, int hit) {
        return rank.matchCount == hit ? rank.reward : 0;
    }
}
