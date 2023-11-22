package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum WinningAmount {

    THREE_MATCH(3,5000),
    FOUR_MATCH(4,50000),
    FIVE_MATCH(5,1500000),
    FIVE_MATCH_AND_BONUS(5,30000000),
    SIX_MATCH(6,2000000000);

    private static final Map<Integer, WinningAmount> WINNING_AMOUNT_FINDER = new HashMap<>();
    static {
        for (WinningAmount winningAmount : WinningAmount.values()) {
            WINNING_AMOUNT_FINDER.put(winningAmount.matchCount, winningAmount);
        }
    }

    private int matchCount;
    private int amount;

    WinningAmount(int matchCount, int amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getAmount() {
        return amount;
    }

    public static WinningAmount findWinningAmountByMatchCount(int matchCount, boolean matchBonus) {
        if (matchBonus == false && matchCount == 5) {
            return FIVE_MATCH;
        }
        return WINNING_AMOUNT_FINDER.get(matchCount);
    }
}
