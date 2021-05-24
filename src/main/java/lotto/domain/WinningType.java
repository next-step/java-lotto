package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;

public enum WinningType {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private static final int SECOND_OR_THIRD_COUNT = 5;

    private static final Map<Integer, WinningType> CACHE =
        Arrays.stream(values())
              .filter(type -> type.getMatchCount() != SECOND_OR_THIRD_COUNT)
              .collect(
                  collectingAndThen(toMap(WinningType::getMatchCount, Function.identity()),
                                    Collections::unmodifiableMap));

    private final int matchCount;
    private final int prize;

    WinningType(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static WinningType find(int matchCount, boolean bonusMatched) {

        if (matchCount == SECOND_OR_THIRD_COUNT) {
            return secondOrThird(bonusMatched);
        }

        return CACHE.getOrDefault(matchCount, NONE);
    }

    private static WinningType secondOrThird(boolean bonusMatched) {
        if (bonusMatched) {
            return SECOND;
        }

        return THIRD;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isWinningLotto() {
        return this != NONE;
    }

    public boolean isSecond() {
        return this == SECOND;
    }
}
