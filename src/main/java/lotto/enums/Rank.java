package lotto.enums;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Rank {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 150_000_000),
    THIRD_PLACE(4, 50_000),
    FOURTH_PLACE(3, 5000);

    private final long matchCount;
    private final long prizeAmount;

    Rank(long matchCount, long prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    private static final Map<Long, Rank> matchCountToRank = Stream.of(values()).collect(toMap(Rank::getMatchCount, Function.identity()));

    public static Optional<Rank> fromCount(long count) {
        return Optional.ofNullable(matchCountToRank.get(count));
    }

    public long calcWinningAmountPerRank(int winningCount) {
        return this.prizeAmount * winningCount;
    }


    public long getMatchCount() {
        return matchCount;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

}