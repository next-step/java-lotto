package lotto.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public enum Ranking {
    NONE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    ;

    private final int matchedCount;
    private final boolean isMatchedBonusNumber;
    private final long winningAmount;

    Ranking(int matchedCount, boolean isMatchedBonusNumber, long winningAmount) {
        this.matchedCount = matchedCount;
        this.isMatchedBonusNumber = isMatchedBonusNumber;
        this.winningAmount = winningAmount;
    }

    public static Ranking result(int matchedCount, boolean isMatchedBonusNumber) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> isEqualMatchedCount(matchedCount, ranking))
                .filter(ranking -> isMatchesSecondOrThird(isMatchedBonusNumber, ranking))
                .findFirst()
                .orElseGet(() -> Ranking.NONE);
    }

    private static boolean isMatchesSecondOrThird(boolean isMatchedBonusNumber, Ranking ranking) {
        if (Set.of(SECOND, THIRD).contains(ranking)) {
            return isMatchedBonusNumber == ranking.isMatchedBonusNumber();
        }
        return true;
    }

    private static boolean isEqualMatchedCount(int matchedCount, Ranking ranking) {
        return Integer.valueOf(matchedCount)
                .equals(ranking.matchedCount);
    }

    public long totalWinningAmount(Integer winningCount) {
        return winningAmount * winningCount;
    }

    public int matchedCount() {
        return matchedCount;
    }

    public long winningAmount() {
        return winningAmount;
    }

    public boolean isMatchedBonusNumber() {
        return isMatchedBonusNumber;
    }
}
