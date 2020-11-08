package lotto;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public enum WinningRank {
    NONE(0, null),
    MATCHES_THREE(5_000, WinningCondition.builder().matchedCount(3).build()),
    MATCHES_FOUR(50_000, WinningCondition.builder().matchedCount(4).build()),
    MATCHES_FIVE(1_500_000, WinningCondition.builder().matchedCount(5).build()),
    MATCHES_SIX(2_000_000_000, WinningCondition.builder().matchedCount(6).build());

    private static final Map<WinningCondition, WinningRank> RANK_BY_CONDITION;
    static {
        RANK_BY_CONDITION = new HashMap<>();
        for (WinningRank rank : WinningRank.values()) {
            RANK_BY_CONDITION.put(rank.winningCondition, rank);
        }
    }

    public final int winningAmount;
    private final WinningCondition winningCondition;

    WinningRank(int winningAmount, WinningCondition winningCondition) {
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
}
