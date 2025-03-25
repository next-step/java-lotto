package step2.lotto.model;

import java.util.Map;

public class PrizeMoney {

    private final static Map<Integer, Integer> prizeMoney = Map.of(
        3, 5000,
        4, 50000,
        5, 1500000,
        6, 2000000000
    );

    public static Money of(Count matchCount) {
        return new Money(prizeMoney.get(matchCount.value()));
    }

}
