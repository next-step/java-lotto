package domain;

import java.util.Arrays;

public enum LottoRank {
    NONE(0, 0L, false),
    THREE(3, 5_000L, false),
    FOUR(4, 50_000L, false),
    FIVE(5, 1_500_000L, false),
    FIVE_WITH_BONUS(5, 30_000_000L, true),
    SIX(6, 2_000_000_000L, false);

    private final int winningCount;
    private final long reward;
    private final boolean matchBonus;

    LottoRank(int winningCount, long reward, boolean matchBonus) {
        this.winningCount = winningCount;
        this.reward = reward;
        this.matchBonus = matchBonus;
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

    public static LottoRank getLottoRank(int winningCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.isMatchCount(winningCount) && lottoRank.isMatchBonus(matchBonus))
                .findFirst()
                .orElse(LottoRank.NONE);
    }

    private boolean isMatchCount(int winningCount) {
        return this.winningCount == winningCount;
    }

    private boolean isMatchBonus(boolean matchBonus) {
        return this.matchBonus == matchBonus;
    }
}