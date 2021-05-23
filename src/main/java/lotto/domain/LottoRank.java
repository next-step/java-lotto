package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final int reward;

    LottoRank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int matchCount() {
        return matchCount;
    }

    public int reward() {
        return reward;
    }

    public static LottoRank of(int matchCount) {
        return Arrays.stream(values())
                .filter(lottoRank -> (lottoRank.matchCount() == matchCount))
                .findFirst()
                .orElse(MISS);
    }
}
