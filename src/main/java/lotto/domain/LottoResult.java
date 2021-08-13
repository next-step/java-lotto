package lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    FAIL(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private int matchCount;
    private int reward;

    LottoResult(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoResult getLottoResult(int matchCount) {
        return Arrays.stream(LottoResult.values())
                     .filter(s -> s.getMatchCount() == matchCount)
                     .findAny()
                     .orElse(FAIL);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

}
