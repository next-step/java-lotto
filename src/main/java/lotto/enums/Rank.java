package lotto.enums;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Rank {
    FIRST_PLACE(6, 2000000000, "1등"),
    SECOND_PLACE(5, 150000000, "2등"),
    THIRD_PLACE(4, 50000, "3등"),
    FOURTH_PLACE(3, 5000, "4등");

    private final long matchCount;
    private final long prizeAmount;
    private final String description;

    Rank(long matchCount, long prizeAmount, String description) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.description = description;
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

    @Override
    public String toString() {
        return this.description;
    }
}

