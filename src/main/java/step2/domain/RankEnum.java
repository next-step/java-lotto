package step2.domain;

public enum RankEnum {
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    SIX_MATCH(6, 2_000_000_000);

    private final int matchCount;
    private final int reward;

    RankEnum(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static int getReward(int hit) {
        int result = 0;

        try {
            for (RankEnum rank : RankEnum.values()) {
                result = compare(rank, hit);
                checkResult(result);
            }
        } catch(ResultEndException e) {
                return result;
        }

        return result;
    }

    private static void checkResult(int result) throws ResultEndException {
        if (result > 0) {
            throw new ResultEndException("get Reward is ended");
        }
    }

    private static int compare(RankEnum rank, int hit) {
        return rank.matchCount == hit ? rank.reward : 0;
    }
}

class ResultEndException extends Exception {
    public ResultEndException(String message) {
        super(message);
    }
}
