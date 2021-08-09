package lotto.step2.domain;

public enum WinningRank {

    FIRST_PLACE(6,2000_000_000),
    SECOND_PLACE(5,1500_000),
    THIRD_PLACE(4,50_000),
    FOURTH_PLACE(3,5000);


    private final int matchCount;
    private final int winnings;


    WinningRank(int matchCount, int winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }
}
