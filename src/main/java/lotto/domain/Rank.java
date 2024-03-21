package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final int winningMoney;

    Rank(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    private static final Map<Integer, Rank> RANK_MAP = Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(Rank::matchCount, Function.identity())));

    public static Rank findRank(int matchCount) {
        return Optional.ofNullable(RANK_MAP.get(matchCount))
                .orElse(MISS);
    }

    public int matchCount() {
        return matchCount;
    }

    public int winningMoney() {
        return winningMoney;
    }
}
