package lotto;

import java.util.stream.Stream;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private int matchCount;
    private int winReward;

    LottoRank(int matchCount, int winReward) {
        this.matchCount = matchCount;
        this.winReward = winReward;
    }

    public static LottoRank searchRank(int countOfMatchUserLotto) {
        return Stream.of(values())
                .filter(LottoResult -> LottoResult.matchCount == countOfMatchUserLotto)
                .findFirst()
                .orElse(MISS);
    }
}
