package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoPricing {

    NO_PRIZE_0(0, () -> 0),
    NO_PRIZE_1(1, () -> 0),
    NO_PRIZE_2(2, () -> 0),
    PRIZE_3(3, () -> 5000),
    PRIZE_4(4, () -> 50000),
    PRIZE_5(5, () -> 1500000),
    PRIZE_6(6, () -> 2000000000),
    ;

    private static final Map<Integer, LottoPricing> lottoPricingMappingCache;

    static {
        lottoPricingMappingCache = new HashMap<>();
        lottoPricingMappingCache.put(0, NO_PRIZE_0);
        lottoPricingMappingCache.put(1, NO_PRIZE_1);
        lottoPricingMappingCache.put(2, NO_PRIZE_2);
        lottoPricingMappingCache.put(3, PRIZE_3);
        lottoPricingMappingCache.put(4, PRIZE_4);
        lottoPricingMappingCache.put(5, PRIZE_5);
        lottoPricingMappingCache.put(6, PRIZE_6);
    }

    final int matchCount;
    final PriceFunction priceFunction;

    LottoPricing(int matchCount, PriceFunction priceFunction) {
        this.matchCount = matchCount;
        this.priceFunction = priceFunction;
    }

    public static LottoPricing getByMatchCount(int matchCount) {
        LottoPricing lottoPricing = lottoPricingMappingCache.get(matchCount);
        if (lottoPricing == null) throw new IllegalArgumentException();
        return lottoPricing;
    }

    public int getPrice() {
        return this.priceFunction.get();
    }
}
