package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum LottoPrize {
    FIRST(6, new Amount(2000000000)),
    SECOND(5, new Amount(1500000)),
    THIRD(4, new Amount(50000)),
    FOURTH(3, new Amount(5000)),
    NONE(0, new Amount(0));

    private static final Map<Integer, LottoPrize> ENUM_MAP;

    private final int matched;
    private final Amount amount;


    LottoPrize(int matched, Amount amount) {
        this.matched = matched;
        this.amount = amount;
    }

    public static LottoPrize fromMatched(int matched) {
        if (!containMatched(matched)) {
            return NONE;
        }
        return ENUM_MAP.get(matched);
    }

    private static boolean containMatched(int matched) {
        return ENUM_MAP.containsKey(matched);
    }

    static {
        ENUM_MAP = Arrays.stream(LottoPrize.values())
                .collect(Collectors.toUnmodifiableMap(LottoPrize::getMatched, lottoPrize -> lottoPrize));
    }

    public int getMatched() {
        return matched;
    }

    public Amount getAmount() {
        return amount;
    }
}
