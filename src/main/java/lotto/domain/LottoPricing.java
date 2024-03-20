package lotto.domain;

import java.util.Arrays;

public enum LottoPricing {

    NO_PRIZE_0(0, () -> 0),
    NO_PRIZE_1(1, () -> 0),
    NO_PRIZE_2(2, () -> 0),
    PRIZE_3(3, () -> 5000),
    PRIZE_4(4, () -> 50000),
    PRIZE_5(5, () -> 1500000),
    PRIZE_6(6, () -> 2000000000),
    ;

    final int matchCount;
    final PriceFunction priceFunction;

    LottoPricing(int matchCount, PriceFunction priceFunction) {
        this.matchCount = matchCount;
        this.priceFunction = priceFunction;
    }

    public static LottoPricing getByMatchCount(int matchCount){
        return Arrays.stream(values())
                .filter(iter -> iter.matchCount == matchCount)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getPrice(){
        return this.priceFunction.get();
    }
}
