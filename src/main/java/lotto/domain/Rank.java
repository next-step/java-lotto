package lotto.domain;

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

    public String getWinningTitle() {
        return winningTitle;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getWinnings() {
        return winnings;
    }
}
