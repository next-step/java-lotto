package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST_PLACE("FIRST_PLACE", 6, 2_000_000_000),
    SECOND_PLACE("SECOND_PLACE", 5, 30_000_000),
    THIRD_PLACE("THIRD_PLACE", 5, 1_500_000),
    FOURTH_PLACE("FOURTH_PLACE", 4, 50_000),
    FIFTH_PLACE("FIFTH_PLACE", 3, 5_000),
    LOST("LOST", 0, 0);

    private final String winningTitle;
    private final int winningCount;
    private final int winnings;

    Rank(String winningTitle, int winningCount, int winnings) {
        this.winningTitle = winningTitle;
        this.winningCount = winningCount;
        this.winnings = winnings;
    }

    public static Rank findRank(int winningCount, boolean hasBonusNumber) {
        if (isSecondPlace(winningCount, hasBonusNumber)) {
            return SECOND_PLACE;
        }
        if (isThirdPlace(winningCount, hasBonusNumber)) {
            return THIRD_PLACE;
        }
        return findCertainPlace(winningCount);
    }

    private static Rank findCertainPlace(int winningCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.isWinningCount(winningCount))
                .findFirst()
                .orElse(LOST);
    }

    private boolean isWinningCount(int winningCount) {
        return this.winningCount == winningCount;
    }

    private static boolean isThirdPlace(int winningCount, boolean hasBonusNumber) {
        return winningCount == THIRD_PLACE.winningCount && !hasBonusNumber;
    }

    private static boolean isSecondPlace(int winningCount, boolean hasBonusNumber) {
        return winningCount == SECOND_PLACE.winningCount && hasBonusNumber;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getWinnings() {
        return winnings;
    }
}
