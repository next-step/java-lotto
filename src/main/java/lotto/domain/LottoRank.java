package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    NONE(0, false, 0L),
    THREE(3, false, 5_000L),
    FOUR(4, false, 50_000L),
    FIVE(5, false, 1_500_000L),
    FIVE_WITH_BONUS(5, true, 30_000_000L),
    SIX(6, false, 2_000_000_000L);

    private final int winningCount;
    private final boolean matchBonus;
    private final long reward;

    LottoRank(int winningCount, boolean matchBonus, long reward) {
        this.winningCount = winningCount;
        this.matchBonus = matchBonus;
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

    public static LottoRank getLottoRank(int winningCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.isMatchCount(winningCount) && lottoRank.isMatchBonus(matchBonus))
                .findFirst()
                .orElse(LottoRank.NONE);
    }

    private boolean isMatchBonus(boolean matchBonus) {
        return this.matchBonus == matchBonus;
    }

    private boolean isMatchCount(int winningCount) {
        return this.winningCount == winningCount;
    }
}
