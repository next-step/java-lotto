package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningAmount {
    public static final int MATCHING_COUNT_THREE = 3;
    public static final int MATCHING_COUNT_FORE = 4;
    public static final int MATCHING_COUNT_FIVE = 5;
    public static final int MATCHING_COUNT_SIX = 6;
    public static final long AMOUNT_THREE_MATCHED = 5_000L;
    public static final long AMOUNT_FORE_MATCHED = 50_000L;
    public static final long AMOUNT_FIVE_MATCHED = 1_500_000L;
    public static final long AMOUNT_SIX_MATCHED = 2_000_000_000L;
    public static final long DEFAULT_AMOUNT = 0L;
    private final Map<Integer, Long> amounts = new HashMap<>();

    public WinningAmount() {
        this.amounts.put(MATCHING_COUNT_THREE, AMOUNT_THREE_MATCHED);
        this.amounts.put(MATCHING_COUNT_FORE, AMOUNT_FORE_MATCHED);
        this.amounts.put(MATCHING_COUNT_FIVE, AMOUNT_FIVE_MATCHED);
        this.amounts.put(MATCHING_COUNT_SIX, AMOUNT_SIX_MATCHED);
    }

    public int size() {
        return this.amounts.size();
    }

    public Long getAmount(int matchingNumber) {
        return this.amounts.getOrDefault(matchingNumber, DEFAULT_AMOUNT);
    }
}
