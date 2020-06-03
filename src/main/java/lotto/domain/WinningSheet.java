package lotto.domain;

import java.util.Arrays;

public enum WinningSheet {
    FAIL(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final int prize;

    WinningSheet(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static WinningSheet findByMatchCount(int matchCount, boolean matchBonus) {
        WinningSheet findSheet = Arrays.stream(WinningSheet.values())
                .filter(winningSheet -> winningSheet.isSameMatchCount(matchCount))
                .findFirst()
                .orElse(WinningSheet.FAIL);

        if (isThirdAndMatchBonus(findSheet, matchBonus)) {
            return SECOND;
        }

        return findSheet;
    }

    private static boolean isThirdAndMatchBonus(WinningSheet winningSheet, boolean matchBonus) {
        return (winningSheet.equals(THIRD) && matchBonus);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    private boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }
}
