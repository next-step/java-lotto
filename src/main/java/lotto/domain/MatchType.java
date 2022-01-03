package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MatchType {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int count;
    private final int money;

    private static final Map<Integer, Integer> MATCH_MAP =
        Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(MatchType::getCount, MatchType::getMoney)));

    MatchType(final int count, final int money) {
        this.count = count;
        this.money = money;
    }

    public int getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }

    public static int getMoneyByCount(final int count) {
        return MATCH_MAP.get(count);
    }

    public static MatchType of(final int count) {
        return Arrays.stream(values())
            .filter(value -> value.count == count)
            .findAny()
            .orElseThrow(IllegalStateException::new);
    }

}
