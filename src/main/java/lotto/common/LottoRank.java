package lotto.common;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int matchCount;
    private int reward;

    LottoRank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoRank getRank(int matchCount, boolean matchBonus) {
        LottoRank[] lottoRanks = LottoRank.values();
        LottoRank result = LottoRank.MISS;

        if (matchCount == LottoRank.SECOND.matchCount) {
            return matchBonus ? LottoRank.SECOND : LottoRank.THIRD;
        }

        for (LottoRank lottoRank : lottoRanks) {
            if (lottoRank.matchCount == matchCount) {
                result = lottoRank;
                break;
            }
        }

        return result;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
