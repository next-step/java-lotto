package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum WinningAmount {

    THREE_MATCH(3,5_000),
    FOUR_MATCH(4,50_000),
    FIVE_MATCH(5,1_500_000),
    FIVE_MATCH_AND_BONUS(5,30_000_000),
    SIX_MATCH(6,2_000_000_000);

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
        if (!matchBonus && matchCount == 5) {
            return FIVE_MATCH;
        }
        return isMatchBonus(matchCount, matchBonus);
    }

    private static WinningAmount isMatchBonus(int matchCount, boolean matchBonus) {
        if (matchBonus && matchCount == 4) {
            return FIVE_MATCH_AND_BONUS;
        }
        return WINNING_AMOUNT_FINDER.get(matchCount);
    }
}
