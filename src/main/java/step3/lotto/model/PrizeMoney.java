package step3.lotto.model;

import java.util.Map;

public class PrizeMoney {

    private final static Map<Long, Long> prizeMoney = Map.of(
        3L, 5000L,
        4L, 50000L,
        5L, 1500000L,
        6L, 2000000000L
    );

    public static Money of(Count matchCount) {
        return new Money(prizeMoney.get(matchCount.value()));
    }

}
