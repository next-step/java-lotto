package lotto;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public enum WinningRank {
    NONE("꽝", 0, null),
    MATCHES_THREE("3개 일치", 5_000, WinningCondition.builder().matchedCount(3).build()),
    MATCHES_FOUR("4개 일치", 50_000, WinningCondition.builder().matchedCount(4).build()),
    MATCHES_FIVE("5개 일치", 1_500_000, WinningCondition.builder().matchedCount(5).build()),
    MATCHES_SIX("6개 일치", 2_000_000_000, WinningCondition.builder().matchedCount(6).build());

    private static final Map<WinningCondition, WinningRank> RANK_BY_CONDITION;

    static {
        RANK_BY_CONDITION = new HashMap<>();
        for (WinningRank rank : WinningRank.values()) {
            RANK_BY_CONDITION.put(rank.winningCondition, rank);
        }
    }

    private final String description;
    public final int winningAmount;
    private final WinningCondition winningCondition;

    WinningRank(String description, int winningAmount, WinningCondition winningCondition) {
        this.description = description;
        this.winningAmount = winningAmount;
        this.winningCondition = winningCondition;
    }

    public static WinningRank getWinningRank(Collection<Integer> winningNumbers, Lotto boughtLotto) {
        WinningCondition winningCondition = getWinningConditionOf(winningNumbers, boughtLotto);
        WinningRank winningRank = RANK_BY_CONDITION.get(winningCondition);
        return winningRank != null ? winningRank : NONE;
    }

    private static WinningCondition getWinningConditionOf(Collection<Integer> winningNumbers, Lotto boughtLotto) {
        int matchedCount = boughtLotto.getMatchedCountCompareTo(winningNumbers);

        return WinningCondition.builder()
                .matchedCount(matchedCount)
                .build();
    }

    public String getDescription() {
        return description;
    }
}
