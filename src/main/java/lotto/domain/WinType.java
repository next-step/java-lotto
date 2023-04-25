package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinType {
    FIRST(6,2000000000),
    SECOND(99, 0),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    FAIL(0, 0);

    private final long matchedQuantity;
    private final long winnings;

    private static final Map<Long, WinType> WIN_TYPE_MAP
            = Collections.unmodifiableMap(Stream.of(values())
                                                .collect(Collectors.toMap(WinType::getMatchedQuantity, x -> x)));

    WinType(long matchedQuantity, long winnings) {
        this.matchedQuantity = matchedQuantity;
        this.winnings = winnings;
    }

    public long getMatchedQuantity() {
        return matchedQuantity;
    }

    public long getWinnings() {
        return winnings;
    }

    public static WinType find(long matchedQuantity) {
        if (WIN_TYPE_MAP.containsKey(matchedQuantity)) {
            return WIN_TYPE_MAP.get(matchedQuantity);
        }

        return FAIL;
    }
}
