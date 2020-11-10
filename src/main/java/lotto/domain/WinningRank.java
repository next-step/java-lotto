package lotto.domain;

import lotto.dto.WinningNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum WinningRank {
    NONE("꽝", 0, null),
    MATCHES_THREE("3개 일치", 5_000, WinningCondition.of(3, false)),
    MATCHES_FOUR("4개 일치", 50_000, WinningCondition.of(4, false)),
    MATCHES_FIVE("5개 일치", 1_500_000, WinningCondition.of(5, false)),
    MATCHES_FIVE_AND_BONUS_NUMBER("5개 일치, 보너스 볼 일치", 30_000_000, WinningCondition.of(5, true)),
    MATCHES_SIX("6개 일치", 2_000_000_000, WinningCondition.of(6, false));

    private static final Map<WinningCondition, WinningRank> RANK_BY_CONDITION;

    static {
        RANK_BY_CONDITION = new HashMap<>();
        for (WinningRank rank : WinningRank.values()) {
            RANK_BY_CONDITION.put(rank.winningCondition, rank);
        }
    }

    private final String description;
    private final int winningAmount;
    private final WinningCondition winningCondition;

    WinningRank(String description, int winningAmount, WinningCondition winningCondition) {
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
