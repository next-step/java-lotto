package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    MISS(0, 0);

    private final int matchCount;
    private final int winningMoney;

    Rank(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    private static final Map<Integer, Rank> rankMap = Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(Rank::getMatchCount, Function.identity())));

    public static Rank findRank(int matchCount) {
        return Optional.ofNullable(rankMap.get(matchCount)).orElse(MISS);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
