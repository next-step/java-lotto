package lotto.domain;

import lotto.dto.WinningNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum WinningRank {
    NONE(0, null),
    MATCHES_THREE(5_000, WinningCondition.of(3, false)),
    MATCHES_FOUR(50_000, WinningCondition.of(4, false)),
    MATCHES_FIVE(1_500_000, WinningCondition.of(5, false)),
    MATCHES_FIVE_AND_BONUS_NUMBER(30_000_000, WinningCondition.of(5, true)),
    MATCHES_SIX(2_000_000_000, WinningCondition.of(6, false));

    private static final Map<WinningCondition, WinningRank> RANK_BY_CONDITION;

    static {
        RANK_BY_CONDITION = new HashMap<>();
        for (WinningRank rank : WinningRank.values()) {
            RANK_BY_CONDITION.put(rank.winningCondition, rank);
        }
    }

    private final int winningAmount;
    private final WinningCondition winningCondition;

    WinningRank(int winningAmount, WinningCondition winningCondition) {
        this.winningAmount = winningAmount;
        this.winningCondition = winningCondition;
    }

    public static WinningRank getWinningRank(WinningNumber winningNumber, Lotto boughtLotto) {
        WinningCondition winningCondition = getWinningConditionOf(winningNumber, boughtLotto);
        WinningRank winningRank = RANK_BY_CONDITION.get(winningCondition);
        return winningRank != null ? winningRank : NONE;
    }

    private static WinningCondition getWinningConditionOf(WinningNumber winningNumber, Lotto boughtLotto) {
        int matchedCount = boughtLotto.getMatchedCountCompareTo(winningNumber);
        boolean bonusNumMatched = boughtLotto.contains(winningNumber);

        return WinningCondition.of(matchedCount, bonusNumMatched);
    }

    public static int getTotalWinningAmount(List<WinningRank> winningRanks) {
        return winningRanks.stream()
                .mapToInt(r -> r.winningAmount)
                .sum();
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public WinningCondition getWinningCondition() {
        return winningCondition;
    }
}
