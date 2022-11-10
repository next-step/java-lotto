package lotto.domain;

import java.util.Arrays;

public enum WinningType {

    NOT_WINNING(0, 0),
    FIVE_PLACE(3, 5_000),
    FOURTH_PLACE(4, 50_000),
    THIRD_PLACE(5, 1_500_000),
    SECOND_PLACE(5, 30_000_000),
    FIRST_PLACE(6, 2_000_000_000);

    private final long matchCount;
    private final int winningAmount;

    WinningType(long matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public static WinningType of(long lottoMatchCount, boolean matchBonus) {
        if (lottoMatchCount == 5) {
            return ofMatchBonus(matchBonus);
        }
        return Arrays.stream(values())
                .filter(winningType -> winningType.matchCount == lottoMatchCount)
                .findFirst()
                .orElse(NOT_WINNING);
    }

    private static WinningType ofMatchBonus(boolean matchBonus) {
        if (matchBonus) {
            return SECOND_PLACE;
        }
        return THIRD_PLACE;
    }

    public long getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
