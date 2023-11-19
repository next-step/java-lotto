package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum WinningAmount {

    THREE_MATCH(3,5000),
    FOUR_MATCH(4,50000),
    FIVE_MATCH(5,1500000),
    SIX_MATCH(6,2000000000);

    private static final Map<Integer, WinningAmount> WINNING_AMOUNT_FINDER = new HashMap<>();
    static {
        for (WinningAmount winningAmount : WinningAmount.values()) {
            WINNING_AMOUNT_FINDER.put(winningAmount.matchCount, winningAmount);
        }
    }

    private Integer matchCount;
    private Integer amount;

    WinningAmount(Integer matchCount, Integer amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getAmount() {
        return amount;
    }

    public static WinningAmount findWinningAmountByMatchCount(int matchCount) {
        return WINNING_AMOUNT_FINDER.get(matchCount);
    }
}
