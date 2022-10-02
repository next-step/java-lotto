package lotto.domain.enums;

/**
 * 등수별 당첨 숫자 갯수
 */
public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);


    private final int matchCount;
    private final int reward;

    LottoRank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public static LottoRank getLottoRank(int matchCount) {
        if (matchCount == FIRST.getMatchCount()) {
            return FIRST;
        }
        if (matchCount == SECOND.getMatchCount()) {
            return SECOND;
        }
        if (matchCount == THIRD.getMatchCount()) {
            return THIRD;
        }
        if (matchCount == FOURTH.getMatchCount()) {
            return FOURTH;
        }
        return NONE;
    }
}
