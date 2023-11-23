package lotto.enums;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Rank {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 150000000),
    THIRD_PLACE(4, 50000),
    FOURTH_PLACE(3, 5000);

    private final long matchCount;
    private final long prizeAmount;

    Rank(int matchCount, long prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    private static final Map<Long, Rank> countToRank = Stream.of(values()).collect(toMap(Rank::getMatchCount, Function.identity()));

    public static Optional<Rank> fromCount(long count) {
        return Optional.ofNullable(countToRank.get(count));
    }

    private long getMatchCount() {
        return matchCount;
    }

    private long getPrizeAmount() {
        return prizeAmount;
    }
}

