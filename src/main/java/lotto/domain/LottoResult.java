package lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(0, 0);

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
