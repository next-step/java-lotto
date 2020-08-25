package cc.oakk.lotto.model;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(0),
    SECOND(1),
    THIRD(2),
    FOURTH(3),
    FIFTH(4),
    NONE(5);

    private final int differentCount;
    Rank(int differentCount) {
        this.differentCount = differentCount;
    }

    public int getDifferentCount() {
        return differentCount;
    }

    private static Map<Integer, Rank> ranks =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Rank::getDifferentCount, Function.identity())));

    public static Rank getRankByDifferentCount(int count) {
        return ranks.getOrDefault(count, NONE);
    }
}
