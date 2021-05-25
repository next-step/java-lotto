package lotto.domain;

import java.util.Arrays;

/**
 * 당첨 결과에 따른 조건과 보상
 */
public enum LottoResult {
    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int matchCount;
    private final int reward;

    LottoResult(final int matchCount, final int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoResult findByMatchCount(final int matchCount, final boolean matchBonus) {
        if (matchBonus &&
                matchCount == LottoResult.SECOND.matchCount) {
            return LottoResult.SECOND;
        }

        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult.isMatch(matchCount))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isMatch(final int matchCount) {
        return this.matchCount == matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
