package lotto.enums;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    FIRST_PLACE(6, false, 2_000_000_000),
    SECOND_PLACE(5, true, 300_000_000),
    THIRD_PLACE(5, false, 150_000_000),
    FOURTH_PLACE(4, false, 50_000),
    FIFTH_PLACE(3, false, 5000);

    private final long matchCount;
    private final boolean containBonus;
    private final long prizeAmount;

    Rank(long matchCount, boolean containBonus, long prizeAmount) {
        this.matchCount = matchCount;
        this.containBonus = containBonus;
        this.prizeAmount = prizeAmount;
    }

    public static Optional<Rank> valueOf(long count, boolean containsBonus) {
        return Arrays.stream(values()).filter(rank -> rank.matchCount == count && rank.containBonus == containsBonus).findFirst();
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

    public boolean getContainBonus() {
        return containBonus;
    }
}