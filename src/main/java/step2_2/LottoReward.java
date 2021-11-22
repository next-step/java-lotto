package step2_2;

import java.util.Arrays;

public enum LottoReward {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    BANG(0, 0);

    private final long matchCount;
    private final int reward;

    LottoReward(long matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoReward getReward(long matchCount) {
        return Arrays.stream(values())
            .filter(lottoReward -> lottoReward.matchCount == matchCount)
            .findAny()
            .orElse(BANG);
    }

    public int getReward() {
        return reward;
    }

    public long getMatchCount() {
        return matchCount;
    }
}
