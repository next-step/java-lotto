package auto.application;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public enum MatchedAmount {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000),
    NONE(0, 0);

    private static final Map<Integer, MatchedAmount> MATCHED_AMOUNT_MAP = new HashMap<>();

    private final int count;
    private final int amount;

    static {
        Arrays.asList(values())
              .forEach(enumValue -> MATCHED_AMOUNT_MAP.put(enumValue.count, enumValue));
    }

    MatchedAmount(int count, int amount) {
        this.count = count;
        this.amount = amount;
    }

    public static MatchedAmount findByCount(int count) {
        if (!MATCHED_AMOUNT_MAP.containsKey(count))
            return NONE;
        return MATCHED_AMOUNT_MAP.get(count);
    }

    public static Map<Integer, Integer> getMatchedCountMap() {
        return MATCHED_AMOUNT_MAP.values()
                                 .stream()
                                 .filter(matchedAmount -> matchedAmount != NONE)
                                 .collect(Collectors.toMap(MatchedAmount::getCount, u -> 0, (u, v) -> u));
    }

    public int getCount() {
        return count;
    }

    public int getAmount() {
        return amount;
    }
}
