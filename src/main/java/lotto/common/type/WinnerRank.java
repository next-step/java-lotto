package lotto.common.type;

import java.util.HashMap;
import java.util.Map;

public enum WinnerRank {
    MISS(new WinnerRankCondition(0, false), 0),

    FIFTH(new WinnerRankCondition(3, false), 5_000),
    FORTH(new WinnerRankCondition(4, false), 50_000),
    THIRD(new WinnerRankCondition(5, false), 1_500_000),
    SECOND(new WinnerRankCondition(5, true), 30_000_000),
    FIRST(new WinnerRankCondition(6, false), 2_000_000_000);


    private final WinnerRankCondition winnerRankCondition;
    private final int reward;

    private static final Map<WinnerRankCondition, WinnerRank> BY_RANK_CONDITION = new HashMap<>();

    static {
        for (WinnerRank winnerRank : values()) {
            BY_RANK_CONDITION.put(winnerRank.winnerRankCondition, winnerRank);
        }
    }

    WinnerRank(WinnerRankCondition winnerRankCondition, int reward) {
        this.winnerRankCondition = winnerRankCondition;
        this.reward = reward;
    }

    public static WinnerRank valueOf(WinnerRankCondition condition) {
        if (!BY_RANK_CONDITION.containsKey(condition)) {
            throw new IllegalArgumentException("No winner rank matched with the count");
        }
        return BY_RANK_CONDITION.get(condition);
    }

    public boolean isSecond(){
        return this == SECOND;
    }

    public int getReward() {
        return reward;
    }

    public int getCorrectNumberCount() {
        return winnerRankCondition.getCorrectNumberCount();
    }
}
