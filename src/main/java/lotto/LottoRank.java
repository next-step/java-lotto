package lotto;

public enum LottoRank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    FIRST(6, 2_000_000_000),
    NONE(0,0);

    private final int matchCount;
    private final int matchReward;

    LottoRank(int matchCount, int matchReward) {
        this.matchCount = matchCount;
        this.matchReward = matchReward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMatchReward() {
        return matchReward;
    }

    public static LottoRank valueOf(int matchCount) {
        if (matchCount < 3) {
            return NONE;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        return FIRST;
    }
}
