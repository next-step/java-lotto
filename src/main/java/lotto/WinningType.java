package lotto;

public enum WinningType {
    FIRST(6, 2000000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);
    private final int matchNumberCount;
    private final int winnings;

    WinningType(int matchNumberCount, int winnings) {
        this.matchNumberCount = matchNumberCount;
        this.winnings = winnings;
    }
}
