package lotto;

import java.util.HashMap;

public enum WinningAmount {

    THREE_MATCH(3,5000),
    FOUR_MATCH(4,50000),
    FIVE_MATCH(5,1500000),
    SIX_MATCH(6,2000000000);

    private static final HashMap<Integer, WinningAmount> WINNING_AMOUNT_FINDER = new HashMap<>(4);
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
        if (WINNING_AMOUNT_FINDER.get(matchCount) == null) {
            throw new IllegalArgumentException("Check match count less then 2 or more then 6");
        }
        return WINNING_AMOUNT_FINDER.get(matchCount);
    }
}
