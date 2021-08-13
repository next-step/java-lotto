package lotto.step2.domain;

public enum WinningRank {

    NONE_PLACE(0, 0),
    FOURTH_PLACE(3, 5000),
    THIRD_PLACE(4, 50_000),
    SECOND_PLACE(5, 1500_000),
    FIRST_PLACE(6, 2000_000_000);


    private final int matchCount;
    private final int winnings;


    WinningRank(int matchCount, int winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinnings() {
        return winnings;
    }

    static WinningRank findWinningRank(int count) {
        if (count == FOURTH_PLACE.matchCount) return FOURTH_PLACE;
        if (count == THIRD_PLACE.matchCount) return THIRD_PLACE;
        if (count == SECOND_PLACE.matchCount) return SECOND_PLACE;
        if (count == FIRST_PLACE.matchCount) return FIRST_PLACE;
        return NONE_PLACE;
    }
}
