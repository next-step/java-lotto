package lotto.domain;

import java.util.Arrays;

/**
 * 당첨 결과에 따른 조건과 보상
 */
public enum LottoResult {
    NONE(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private final int matchCount;
    private final int reward;

    LottoResult(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoResult findByMatchCount(int matchCount) {
        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult.isMatch(matchCount))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isMatch(int matchCount){
        return this.matchCount == matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
