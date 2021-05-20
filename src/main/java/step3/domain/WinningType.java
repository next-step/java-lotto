package step3.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;

public enum WinningType {

    NONE(0, 0),
    THREE_COUNT(3, 5_000),
    FOUR_COUNT(4, 50_000),
    FIVE_COUNT(5, 1_500_000),
    SIX_COUNT(6, 2_000_000_000);

    private static final Map<Integer, WinningType> CACHE =
        Arrays.stream(values())
              .collect(
                  collectingAndThen(toMap(WinningType::getMatchCount, Function.identity()),
                                    Collections::unmodifiableMap));

    private final int matchCount;
    private final int prize;

    WinningType(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static WinningType ofMatchCount(int matchCount) {
        return CACHE.getOrDefault(matchCount, NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
