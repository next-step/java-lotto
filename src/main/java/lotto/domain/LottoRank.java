package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    NONE(0, 0L),
    THREE(3, 5_000L),
    FOUR(4, 50_000L),
    FIVE(5, 1_500_000L),
    SIX(6, 2_000_000_000L);

    private final int winningCount;
    private final long reward;

    LottoRank(int winningCount, long reward) {
        this.winningCount = winningCount;
        this.reward = reward;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public long getReward() {
        return reward;
    }

    public long getTotalReward(int count) {
        return reward * count;
    }

    public static LottoRank getLottoRank(int winningCount) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.isMatchCount(winningCount))
                .findFirst()
                .orElse(LottoRank.NONE);
    }

    private boolean isMatchCount(int winningCount) {
        return this.winningCount == winningCount;
    }
}
