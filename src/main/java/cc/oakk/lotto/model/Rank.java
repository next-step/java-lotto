package cc.oakk.lotto.model;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(0),
    SECOND(1, true),
    THIRD(1),
    FOURTH(2),
    FIFTH(3),
    NONE(4);

    private static final Map<Integer, Rank> ranksWithoutBonus =
            Collections.unmodifiableMap(Stream.of(values())
                    .filter(v -> !v.isBonus())
                    .collect(Collectors.toMap(Rank::getDifferentCount, Function.identity())));

    private static final Map<Integer, Rank> ranksOfBonus =
            Collections.unmodifiableMap(Stream.of(values())
                    .filter(Rank::isBonus)
                    .collect(Collectors.toMap(Rank::getDifferentCount, Function.identity())));

    private final int differentCount;
    private final boolean bonus;

    Rank(int differentCount) {
        this.differentCount = differentCount;
        this.bonus = false;
    }

    Rank(int differentCount, boolean bonus) {
        this.differentCount = differentCount;
        this.bonus = bonus;
    }

    public int getDifferentCount() {
        return differentCount;
    }

    public boolean isBonus() {
        return bonus;
    }

    public static Rank getRankByDifferentCount(int count, boolean hasBonus) {
        if (hasBonus && ranksOfBonus.containsKey(count)) {
            return ranksOfBonus.get(count);
        }
        return ranksWithoutBonus.getOrDefault(count, NONE);
    }
}
