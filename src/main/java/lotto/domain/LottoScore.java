package lotto.domain;

import java.util.Arrays;

public enum LottoScore {
    NOTHING(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    ;

    private final int matchedCnt;
    private final boolean isBoundMatched;
    private final int reward;

    LottoScore(int matchedCnt, boolean isBoundMatched, int reward) {
        this.matchedCnt = matchedCnt;
        this.isBoundMatched = isBoundMatched;
        this.reward = reward;
    }

    public int getMatchedCnt() {
        return matchedCnt;
    }

    public boolean getIsBoundMatched() {
        return isBoundMatched;
    }

    public int getReward() {
        return reward;
    }

    public static LottoScore calculateScore(int matchedCnt, boolean isBonusMatched) {
        LottoScore lottoScore = Arrays.stream(
            LottoScore.values()
        ).filter(
            score -> score.matchedCnt == matchedCnt
        ).findAny().orElse(NOTHING);

        if (lottoScore == LottoScore.THIRD && isBonusMatched)
            return SECOND;

        return lottoScore;
    }
}
