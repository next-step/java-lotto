package lotto.domain;

import java.util.Arrays;

public enum WinningType {
    FIRST(2_000_000_000, 1, 6, false),
    FIVE(5_000, 5, 3, false),
    FOURTH(50_000, 4, 4, false),
    NO_MATCH(0, 0, 0, false),
    SECOND(3_000_000, 2, 5, true),
    THIRD(1_500_000, 3, 5, false);

    private int prize;
    private int rank;
    private int matchCount;
    private boolean matchBonus;

    public int getPrize() {
        return prize;
    }

    public static WinningType findByMatchCountAndMatchBonus(int matchCount, boolean matchBonus) {
        return Arrays.stream(WinningType.values())
                .filter(winningType -> winningType.matchCount == matchCount)
                .filter(winningType -> winningType.isMatchBonus() == matchBonus)
                .findAny()
                .orElse(NO_MATCH);
    }

    public int getRank() {
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    WinningType(int prize, int rank, int matchCount, boolean matchBonus) {
        this.prize = prize;
        this.rank = rank;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }
}