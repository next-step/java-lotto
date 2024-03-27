package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_MATCH(0, 0);

    private int matchCount;
    private int reward;

    LottoRank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static LottoRank getLottoRank(int matchCount, boolean matchBonus) {
        LottoRank resultRank = Arrays.stream(values())
            .filter(lottoRank -> lottoRank.matchCount == matchCount)
            .findFirst()
            .orElseGet(() -> LottoRank.NO_MATCH);

        if (resultRank.matchCount == LottoRank.SECOND.matchCount && matchBonus) {
            return LottoRank.SECOND;
        } else if (resultRank.matchCount == LottoRank.THIRD.matchCount) {
            return LottoRank.THIRD;
        }

        return resultRank;
    }
}
