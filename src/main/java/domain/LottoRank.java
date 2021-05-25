package domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000L, false),
    SECOND(5, 30_000_000L, true),
    THIRD(5, 1_500_000L, false),
    FOURTH(4, 50_000L, false),
    FIRTH(3, 5_000L, false),
    NO_MATCH(0, 0L, false);

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
                .filter(lottoRank -> lottoRank.isMatch(winningCount, matchBonus))
                .findFirst()
                .orElse(LottoRank.NO_MATCH);
    }

    private boolean isMatch(int winningCount, boolean matchBonus) {
        if(matchBonus == true) {
            return isMatchCount(winningCount);
        }
        return isMatchCount(winningCount) && isMatchBonus(matchBonus);
    }

    private boolean isMatchCount(int winningCount) {
        return this.winningCount == winningCount;
    }

    private boolean isMatchBonus(boolean matchBonus) {
        return this.matchBonus == matchBonus;
    }
}