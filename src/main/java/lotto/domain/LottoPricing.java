package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum LottoPricing {

    NO_PRIZE_0(0, () -> 0, false),
    NO_PRIZE_1(1, () -> 0, false),
    NO_PRIZE_2(2, () -> 0, false),
    PRIZE_3(3, () -> 5000, false),
    PRIZE_4(4, () -> 50000, false),
    PRIZE_5(5, () -> 1500000, false),
    PRIZE_6(6, () -> 2000000000, false),
    PRIZE_5_BONUS(5, () -> 30000000, true);

    private static final Map<String, LottoPricing> lottoPricingMappingCache;

    static {
        lottoPricingMappingCache = Arrays.stream(LottoPricing.values())
                .collect(Collectors.toMap(
                        iter -> LottoPricingKey.getKey(iter.matchCount).get(iter.matchCount, iter.isBonus),
                        iter -> iter));
    }

    final int matchCount;
    final boolean isBonus;
    final PriceFunction priceFunction;

    LottoPricing(int matchCount, PriceFunction priceFunction, boolean isBonus) {
        this.matchCount = matchCount;
        this.priceFunction = priceFunction;
        this.isBonus = isBonus;
    }

    public static LottoPricing getByMatchCount(int matchCount, boolean isBonus) {
        String key = LottoPricingKey.getKey(matchCount).get(matchCount, isBonus);
        LottoPricing lottoPricing = lottoPricingMappingCache.get(key);
        if (lottoPricing == null) throw new IllegalArgumentException();
        return lottoPricing;
    }

    public long getPrice() {
        return this.priceFunction.get();
    }
}
